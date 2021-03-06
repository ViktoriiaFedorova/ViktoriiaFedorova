package base.hw2;

import enums.hw1.IndexPageTexts;
import enums.hw1.Users;
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
        System.out.println("_" + Thread.currentThread().getId() + "_");
        chromeDriver.get("https://epam.github.io/JDI/");
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getName());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUserLogIn(Users user) {
        Assert.assertEquals(userName.getText(), user.getUserName());
    }

    public void checkPageTitle(IndexPageTexts pageTitle) {
        Assert.assertEquals(chromeDriver.getTitle().toLowerCase(), pageTitle.getText());
    }

    public void checkHeaderItems(String[] headerItems) {
        List<String> elements = chromeDriver
                .findElements(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8'] > li"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertEquals(elements.toArray(), headerItems);
    }

    public void checkImages(String[] imagesURLs) {
        List<String> imageUrls = chromeDriver.findElements(By.cssSelector("[class='row clerafix benefits'] [class^='icons-benefit icon-']"))
                .stream().map(x -> x.getCssValue("background-image")).collect(Collectors.toList());
        Assert.assertEquals(imageUrls.toArray(), imagesURLs);
    }

    public void checkImagesTexts(String[] imagesTexts) {
        List<String> imageTexts = chromeDriver.findElements(By.cssSelector("[class='row clerafix benefits'] [class^='benefit-txt']"))
                .stream().map(x -> x.getText().toLowerCase()).collect(Collectors.toList());
        Assert.assertEquals(imageTexts.toArray(), imagesTexts);
    }

    public void checkHeaderTexts(String mainTitle, String jdiText) {
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[name='main-title']")).getText().toLowerCase(), mainTitle);
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[name='jdi-text']")).getText().toLowerCase(), jdiText);
    }

    public void checkIFrame() {
        Assert.assertTrue(iFrame.isDisplayed());
    }

    public void checkIFrameLogo() {
        chromeDriver.switchTo().frame(iFrame);
        Assert.assertTrue(epamLogo.isDisplayed());
    }

    public void goToOriginWindow() {
        chromeDriver.switchTo().defaultContent();
    }

    public void checkSubHeaderText(IndexPageTexts subHeader) {
        Assert.assertEquals(subHeader.getText().toLowerCase(), subHeader.getText());
    }

    public void checkGitLink(IndexPageTexts link) {
        Assert.assertTrue(chromeDriver.findElement(By.linkText(link.getText().toUpperCase())).isDisplayed());
        Assert.assertEquals(chromeDriver.findElement(By.linkText(link.getText().toUpperCase())).getAttribute("href"), link.getLinkURL());
    }

    public void checkLeftSection() {
        Assert.assertTrue(leftNavigation.isDisplayed());
    }

    public void checkFooter() {
        Assert.assertTrue(footer.isDisplayed());
    }

    public void checkBenefitTexts(String iconName, String benefitText) {

        WebElement icon = chromeDriver.findElement
                (By.xpath("//*[@class='row clerafix benefits']//div[@class='benefit' " + "and .//*[contains(@class,'" + iconName + "')]]"));

        Assert.assertEquals(icon.getText(), benefitText);
    }
}
