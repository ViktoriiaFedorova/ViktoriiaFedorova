package base.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import enums.IndexPageTexts;
import enums.Users;

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
    private SelenideElement headerItemService;

    @FindBy(css = "div>ul>li>a[ui='label']")
    private SelenideElement leftNavItemService;

    @FindBy(css = "[class='dropdown-menu'] [href='different-elements.html']")
    private SelenideElement differentElementsItemInHeader;

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
        headerItemService.click();
        $$(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8'] [class='dropdown-menu'] > li"))
                    .shouldBe(CollectionCondition.texts(defaultServiceOptions));
    }

    public void checkServiceDropdownOptionsFromLeftNav (String[] defaultServiceOptions){
        leftNavItemService.click();
        $$(By.cssSelector("div>ul>li>ul[class='sub'] > li"))
                .shouldBe(CollectionCondition.texts(defaultServiceOptions));
    }

    public DifferentElementsPage openDifferentElementsFromHeader() {
        headerItemService.click();
        differentElementsItemInHeader.click();
        return page(DifferentElementsPage.class);
    }
}
