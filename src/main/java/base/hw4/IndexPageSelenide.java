package base.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.IndexPageTexts;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexPageSelenide {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id = 'user-name']")
    private SelenideElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8'] [class='dropdown-toggle']")
    private SelenideElement serviceInHeader;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8'] [class='dropdown-menu'] > li")
    private ElementsCollection serviceOptionsInHeader;

    @FindBy(css = "div>ul>li>a[ui='label']")
    private SelenideElement serviceInLeftNav;

    @FindBy(css = "div>ul>li>ul[class='sub'] > li")
    private ElementsCollection serviceOptionsInLeftNav;

    @FindBy(css = "[class='dropdown-menu'] [href='different-elements.html']")
    private SelenideElement differentElementsItemInHeader;

    @FindBy(css = "[class='dropdown-menu'] [href='dates.html']")
    private SelenideElement datesInHeader;

    @Step("Login with login: <{user.name}> and password: <{user.password}>")
    public void login(Users user) {
        loginIcon.click();
        userField.setValue(user.getName());
        passwordField.setValue(user.getPassword());
        submitButton.click();
    }

    @Step("Displayed page title should be <{pageTitle.text}>")
    public void checkPageTitle(IndexPageTexts pageTitle) {
        assertThat(title().toLowerCase(), is(pageTitle.getText()));
    }

    @Step("User <{user}> is logged in")
    public void checkUserLogIn(Users user) {
        assertThat(userName.getText(), is(user.getUserName()));
    }

    @Step("There are following options under Service menu in header: <{defaultServiceOptions}>")
    public void checkServiceDropdownOptionsFromHeader (String[] defaultServiceOptions){
        serviceInHeader.click();
        serviceOptionsInHeader.shouldBe(CollectionCondition.texts(defaultServiceOptions));
    }

    @Step("There are following options under Service menu in left navigation: <{defaultServiceOptions}>")
    public void checkServiceDropdownOptionsFromLeftNav (String[] defaultServiceOptions){
        serviceInLeftNav.click();
        serviceOptionsInLeftNav.shouldBe(CollectionCondition.texts(defaultServiceOptions));
    }

    @Step("Open Different Elements page via the option under Service in header")
    public DifferentElementsPage openDifferentElementsFromHeader() {
        if(!serviceOptionsInHeader.get(0).isDisplayed())
            serviceInHeader.click();
        differentElementsItemInHeader.click();
        return page(DifferentElementsPage.class);
    }

    public DatesPage openDatesPageFromHeader(){
        if(!serviceOptionsInHeader.get(0).isDisplayed())
            serviceInHeader.click();
        datesInHeader.click();
        return page(DatesPage.class);
    }
}
