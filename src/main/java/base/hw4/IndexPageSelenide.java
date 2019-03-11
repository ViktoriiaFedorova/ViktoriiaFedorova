package base.hw4;

import enums.IndexPageTexts;
import enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class IndexPageSelenide {

    private WebDriver chromeDriver;

    public IndexPageSelenide(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id = 'user-name']")
    private WebElement userName;

    private WebDriver driver;

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getName());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void openIndexPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void checkPageTitle(IndexPageTexts pageTitle) {
        Assert.assertEquals(chromeDriver.getTitle().toLowerCase(), pageTitle.getText());
    }

    public void checkUserLogIn(Users user) {
        Assert.assertEquals(userName.getText(), user.getUserName());
    }

}
