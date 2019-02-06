package hw1;

import base.IndexPage;
import base.SeleniumBase;
import enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends SeleniumBase {
    private IndexPage indexPage;
    private WebDriver chromeDriver;

    @BeforeMethod
    public void initTest(){
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        indexPage = PageFactory.initElements(chromeDriver, IndexPage.class);
    }

    @AfterMethod
    //step 17: close browser
    public void finishTest(){
        chromeDriver.close();
    }

    @Test
    public  void test1(){

        //step 1: open test site by URL https://epam.github.io/JDI/
        indexPage.open();

        //step 2: assert browser title
        indexPage.checkPageTitle();

        //step 3: perform login
        indexPage.login(Users.PITERCHAILOVSKII);

        //step 4: assert user is logged in (check user name in the left-top corner)
        indexPage.checkUserLogIn(Users.PITERCHAILOVSKII);

        //step 5: assert browser title
        indexPage.checkPageTitle();

        //step 6: assert there are 4 items ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS") displayed with proper texts on the header
        indexPage.checkHeaderItems();

        //step 7: assert there are 4 images displayed
        indexPage.checkImages();

        //step 8: assert there are 4 texts below 4 images
        indexPage.checkImagesTexts();

        //step 9: assert main headers texts
        indexPage.checkHeaderTexts();

        //step 10: assert iframe exists in the center of the page
        indexPage.checkIFrame();

        //step 11: assert there is EPAM logo in the left-top corner in the iframe
        indexPage.checkIFrameLogo();

        //step 12: switch to original window back (from iframe)
        indexPage.goToOriginWindow();

        //step 13: assert sub header text
        indexPage.checkSubHeaderText();

        //step 14: assert 'JDI GITHUB' is a link and its URL = https://github.com/epam/JDI
        indexPage.checkGitLink();

        //step 15: assert there is left section
        indexPage.checkLeftSection();

        //step 16: assert there is footer
        indexPage.checkFooter();

    }
}
