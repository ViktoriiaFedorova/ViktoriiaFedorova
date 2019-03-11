package base.hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.IndexPageTexts;
import enums.Users;
import enums.hw4.ServicePageOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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

    public void login(Users user) {
        loginIcon.click();
        userField.setValue(user.getName());
        passwordField.setValue(user.getPassword());
        submitButton.click();
    }

    public void checkPageTitle(IndexPageTexts pageTitle) {
        Assert.assertEquals(Selenide.title().toLowerCase(), pageTitle.getText());
    }

    public void checkUserLogIn(Users user) {
        Assert.assertEquals(userName.getText(), user.getUserName());
    }

    public void checkServiceDropdownOptions (List<ServicePageOptions> serviceOptions){
    }

}
