package base.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.IndexPageTexts;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;

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

    public void login(Users user) {
        loginIcon.click();
        userField.setValue(user.getName());
        passwordField.setValue(user.getPassword());
        submitButton.click();
    }

    public void checkPageTitle(IndexPageTexts pageTitle) {
        Assert.assertEquals(title().toLowerCase(), pageTitle.getText());
    }

    public void checkUserLogIn(Users user) {
        Assert.assertEquals(userName.getText(), user.getUserName());
    }

    public void checkServiceDropdownOptionsFromHeader (String[] defaultServiceOptions){
        serviceInHeader.click();
        serviceOptionsInHeader.shouldBe(CollectionCondition.texts(defaultServiceOptions));
    }

    public void checkServiceDropdownOptionsFromLeftNav (String[] defaultServiceOptions){
        serviceInLeftNav.click();
        serviceOptionsInLeftNav.shouldBe(CollectionCondition.texts(defaultServiceOptions));
    }

    public DifferentElementsPage openDifferentElementsFromHeader() {
        if(!serviceOptionsInHeader.get(0).isDisplayed())
            serviceInHeader.click();
        differentElementsItemInHeader.click();
        return page(DifferentElementsPage.class);
    }

    public DatesPage openDatesPagefromHeader(){
        if(!serviceOptionsInHeader.get(0).isDisplayed())
            serviceInHeader.click();
        datesInHeader.click();
        return page(DatesPage.class);
    }
}
