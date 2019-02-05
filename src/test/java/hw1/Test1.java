package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.setProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.ArrayMatching.arrayContaining;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

public class Test1 {

    @BeforeSuite
    public void BeforeSuite(){
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    @Test
    public  void test1(){

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        //step 1: open test site by URL https://epam.github.io/JDI/
        chromeDriver.navigate().to("https://epam.github.io/JDI/");

        //step 2: assert browser title
        Assert.assertEquals(chromeDriver.getTitle(), "Home Page");

        //step 3: perform login
        chromeDriver.findElement(By.cssSelector("[id='user-icon']")).click();
        chromeDriver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        chromeDriver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        chromeDriver.findElement(By.cssSelector("[id='login-button']")).click();

        //step 4: assert user is logged in (check user name in the left-top corner)
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[id = 'user-name']")).getText(), "PITER CHAILOVSKII");

        //step 5: assert browser title = step 2

        //step 6: assert there are 4 items ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS") displayed with proper texts on the header
        List<String> elements = chromeDriver
                .findElements(By.xpath("//*[not(self::iframe)]//*[@class='uui-navigation nav navbar-nav m-l8']/li"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertEquals(elements.toArray(), new String[]{"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"});

        //step 7: assert there are 4 images displayed
        List<String> imageUrls = chromeDriver.findElements(By.cssSelector("[class='row clerafix benefits'] [class^='icons-benefit icon-']"))
                .stream().map(x -> x.getCssValue("background-image")).collect(Collectors.toList());
        Assert.assertEquals(4, imageUrls.size());
        assertThat(imageUrls, either(everyItem(containsString(".png"))).or(everyItem(containsString(".jpg"))));

        //step 8: assert there are 4 texts below 4 images

        //step 9: assert main headers texts
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[name='main-title']")).getText().toLowerCase(),
                "EPAM framework Wishes…".toLowerCase());
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[name='jdi-text']")).getText().toLowerCase(),
                ("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat " +
                        "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.").toLowerCase());

        //step 10: assert iframe exists in the center of the page
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //step 11: assert there is EPAM logo in the left-top corner in the iframe
        Assert.assertTrue(chromeDriver.switchTo().frame(chromeDriver.findElement(By.cssSelector("[id='iframe']"))).findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //step 12: switch to original window back (from iframe)

        //step 13: assert sub header text
        Assert.assertEquals(chromeDriver.findElement(By.cssSelector("[target='_blank']")).getText().toLowerCase(), "JDI Github".toLowerCase());

        //step 14: assert 'JDI GITHUB' is a link and its URL = https://github.com/epam/JDI
        Assert.assertTrue(chromeDriver.findElement(By.linkText("JDI Github".toUpperCase())).isDisplayed());
        Assert.assertEquals(chromeDriver.findElement(By.linkText("JDI Github".toUpperCase())).getAttribute("href"), "https://github.com/epam/JDI");

        //step 15: assert there is left section
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("[name='navigation-sidebar']")).isDisplayed());

        //step 16: assert there is footer
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        //step 17: close browser
        chromeDriver.close();
    }
}
