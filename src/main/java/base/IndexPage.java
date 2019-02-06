package base;

import enums.HeaderItems;
import enums.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class IndexPage {

    private WebDriver chromeDriver;

    public IndexPage(WebDriver chromeDriver) {
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

    @FindBy(css = "[id='iframe']")
    private WebElement iFrame;

    @FindBy(css = "[id='epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = "[target='_blank']")
    private WebElement subHeader;

    @FindBy(css = "[name='navigation-sidebar']")
    private WebElement leftNavigation;

    @FindBy(css = "[class='footer-bg']")
    private WebElement footer;

    public void open() {
        chromeDriver.get("https://epam.github.io/JDI/");
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getName());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUserLogIn(Users user){
        Assert.assertEquals(userName.getText(), user.getUserName());
    }

    public void checkPageTitle(){
        Assert.assertEquals(chromeDriver.getTitle(), "Home Page");
    }

    public void checkHeaderItems(){
        List<String> elements = chromeDriver
                .findElements(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8'] > li"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertEquals(elements.toArray(), new String[]{HeaderItems.HOME.getItemText(), HeaderItems.CONTACTFORM.getItemText(),
                HeaderItems.SERVICE.getItemText(), HeaderItems.METALSCOLORS.getItemText()});
    }

    public void checkImages(){
        List<String> imageUrls = chromeDriver.findElements(By.cssSelector("[class='row clerafix benefits'] [class^='icons-benefit icon-']"))
                .stream().map(x -> x.getCssValue("background-image")).collect(Collectors.toList());
        Assert.assertEquals(imageUrls.toArray(),
                new String[]{"url(\"https://epam.github.io/JDI/images/sprite.png\")",
                        "url(\"https://epam.github.io/JDI/images/sprite.png\")",
                        "url(\"https://epam.github.io/JDI/images/sprite.png\")",
                        "url(\"https://epam.github.io/JDI/images/sprite.png\")"});
    }

    public void checkImagesTexts(){
        List<String> imageTexts = chromeDriver.findElements(By.cssSelector("[class='row clerafix benefits'] [class^='benefit-txt']"))
                .stream().map(x -> x.getText()).collect(Collectors.toList());
        Assert.assertEquals(imageTexts.toArray(),
                new String[]{"To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                        "To be flexible and\n" +
                                "customizable",
                        "To be multiplatform",
                        "Already have good base\n" +
                                "(about 20 internal and\n" +
                                "some external projects),\n" +
                                "wish to get more…"});
    }

    public void checkHeaderTexts(){
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[name='main-title']")).getText().toLowerCase(),
                "EPAM framework Wishes…".toLowerCase());
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[name='jdi-text']")).getText().toLowerCase(),
                ("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat " +
                        "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.").toLowerCase());
    }

    public void checkIFrame(){
        Assert.assertTrue(iFrame.isDisplayed());
    }

    public void checkIFrameLogo(){
        chromeDriver.switchTo().frame(iFrame);
        Assert.assertTrue(epamLogo.isDisplayed());
        //Assert.assertTrue(chromeDriver.switchTo().frame(chromeDriver.findElement(By.cssSelector("[id='iframe']"))).findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void goToOriginWindow(){
        chromeDriver.switchTo().defaultContent();
    }

    public void checkSubHeaderText(){
        Assert.assertEquals(subHeader.getText().toLowerCase(), "JDI Github".toLowerCase());
    }

    public void checkGitLink(){
        Assert.assertTrue(chromeDriver.findElement(By.linkText("JDI Github".toUpperCase())).isDisplayed());
        Assert.assertEquals(chromeDriver.findElement(By.linkText("JDI Github".toUpperCase())).getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSection(){
        Assert.assertTrue(leftNavigation.isDisplayed());
    }

    public void checkFooter(){
        Assert.assertTrue(footer.isDisplayed());
    }
}
