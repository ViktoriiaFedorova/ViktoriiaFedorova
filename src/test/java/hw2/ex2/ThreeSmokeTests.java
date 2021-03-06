package hw2.ex2;

import base.hw2.IndexPage;
import base.hw1.SeleniumBase;
import enums.hw1.IndexPageTexts;
import enums.hw1.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class ThreeSmokeTests extends SeleniumBase {
    private IndexPage indexPage;
    private ThreadLocal<WebDriver> threads = new ThreadLocal<>();
    WebDriver chromeDriver;

    @BeforeMethod(alwaysRun = true)
    public synchronized void initTest(){
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        threads.set(chromeDriver);
        System.out.println("_" + Thread.currentThread().getId() + "_");
        indexPage = PageFactory.initElements(threads.get(), IndexPage.class);
    }

    @AfterMethod(alwaysRun = true)
    //step 17: close browser
    public  synchronized void finishTest(){
        System.out.println("_" + Thread.currentThread().getId() + "_");
        threads.get().close();
    }

    @Test (groups = {"Smoke1"})
    public synchronized   void test1Smoke1(){
        System.out.println("_" + Thread.currentThread().getId() + "_");
        System.out.println("index page" + indexPage.toString());
        //step 1: open test site by URL https://epam.github.io/JDI/
        indexPage.open();

        //step 2: assert browser title
        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 3: perform login
        indexPage.login(Users.PITERCHAILOVSKII);
//
//        //step 4: assert user is logged in (check user name in the left-top corner)
//        indexPage.checkUserLogIn(Users.PITERCHAILOVSKII);
//
//        //step 5: assert browser title
//        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);
//
//        //step 6: assert there are 4 items ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS") displayed with proper texts on the header
//        indexPage.checkHeaderItems(new String[] {HeaderItems.HOME.toString(), HeaderItems.CONTACT_FORM.toString(),
//                        HeaderItems.SERVICE.toString(), HeaderItems.METALS_COLORS.toString()});
//
//        //step 7: assert there are 4 images displayed
//        indexPage.checkImages(new String[] {BenefitsSection.PRACTISE.getBenefitIcon(), BenefitsSection.CUSTOM.getBenefitIcon(),
//                BenefitsSection.MULTI.getBenefitIcon(), BenefitsSection.BASE.getBenefitIcon()});
//
//        //step 8: assert there are 4 texts below 4 images
//        indexPage.checkImagesTexts(new String[] {BenefitsSection.PRACTISE.getBenefitText(), BenefitsSection.CUSTOM.getBenefitText(),
//                BenefitsSection.MULTI.getBenefitText(), BenefitsSection.BASE.getBenefitText()});
//
//        //step 9: assert main headers texts
//        indexPage.checkHeaderTexts(IndexPageTexts.MAIN_TITLE.getText(), IndexPageTexts.JDI_TEXT.getText());
//
//        //step 10: assert iframe exists in the center of the page
//        indexPage.checkIFrame();
//
//        //step 11: assert there is EPAM logo in the left-top corner in the iframe
//        indexPage.checkIFrameLogo();
//
//        //step 12: switch to original window back (from iframe)
//        indexPage.goToOriginWindow();
//
//        //step 13: assert sub header text
//        indexPage.checkSubHeaderText(IndexPageTexts.SUB_HEADER);
//
//        //step 14: assert 'JDI GITHUB' is a link and its URL = https://github.com/epam/JDI
//        indexPage.checkGitLink(IndexPageTexts.SUB_HEADER);
//
//        //step 15: assert there is left section
//        indexPage.checkLeftSection();
//
//        //step 16: assert there is footer
//        indexPage.checkFooter();
    }

    @Test (groups = {"Smoke1"})
    public synchronized void test1Smoke2(){
        System.out.println("_" + Thread.currentThread().getId() + "_");

        //step 1: open test site by URL https://epam.github.io/JDI/
        indexPage.open();

        //step 2: assert browser title
        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 3: perform login
        indexPage.login(Users.PITERCHAILOVSKII);
//
//        //step 4: assert user is logged in (check user name in the left-top corner)
//        indexPage.checkUserLogIn(Users.PITERCHAILOVSKII);
//
//        //step 5: assert browser title
//        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);
//
//        //step 6: assert there are 4 items ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS") displayed with proper texts on the header
//        indexPage.checkHeaderItems(new String[] {HeaderItems.HOME.toString(), HeaderItems.CONTACT_FORM.toString(),
//                        HeaderItems.SERVICE.toString(), HeaderItems.METALS_COLORS.toString()});
//
//        //step 7: assert there are 4 images displayed
//        indexPage.checkImages(new String[] {BenefitsSection.PRACTISE.getBenefitIcon(), BenefitsSection.CUSTOM.getBenefitIcon(),
//                BenefitsSection.MULTI.getBenefitIcon(), BenefitsSection.BASE.getBenefitIcon()});
//
//        //step 8: assert there are 4 texts below 4 images
//        indexPage.checkImagesTexts(new String[] {BenefitsSection.PRACTISE.getBenefitText(), BenefitsSection.CUSTOM.getBenefitText(),
//                BenefitsSection.MULTI.getBenefitText(), BenefitsSection.BASE.getBenefitText()});
//
//        //step 9: assert main headers texts
//        indexPage.checkHeaderTexts(IndexPageTexts.MAIN_TITLE.getText(), IndexPageTexts.JDI_TEXT.getText());
//
//        //step 10: assert iframe exists in the center of the page
//        indexPage.checkIFrame();
//
//        //step 11: assert there is EPAM logo in the left-top corner in the iframe
//        indexPage.checkIFrameLogo();
//
//        //step 12: switch to original window back (from iframe)
//        indexPage.goToOriginWindow();
//
//        //step 13: assert sub header text
//        indexPage.checkSubHeaderText(IndexPageTexts.SUB_HEADER);
//
//        //step 14: assert 'JDI GITHUB' is a link and its URL = https://github.com/epam/JDI
//        indexPage.checkGitLink(IndexPageTexts.SUB_HEADER);
//
//        //step 15: assert there is left section
//        indexPage.checkLeftSection();
//
//        //step 16: assert there is footer
//        indexPage.checkFooter();
    }

    @Test (groups = {"Smoke1"})
    public synchronized void test1Smoke3(){
        System.out.println("_" + Thread.currentThread().getId() + "_");

        //step 1: open test site by URL https://epam.github.io/JDI/
        indexPage.open();

        //step 2: assert browser title
        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 3: perform login
        indexPage.login(Users.PITERCHAILOVSKII);

//        //step 4: assert user is logged in (check user name in the left-top corner)
//        indexPage.checkUserLogIn(Users.PITERCHAILOVSKII);
//
//        //step 5: assert browser title
//        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);
//
//        //step 6: assert there are 4 items ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS") displayed with proper texts on the header
//        indexPage.checkHeaderItems(new String[] {HeaderItems.HOME.toString(), HeaderItems.CONTACT_FORM.toString(),
//                        HeaderItems.SERVICE.toString(), HeaderItems.METALS_COLORS.toString()});
//
//        //step 7: assert there are 4 images displayed
//        indexPage.checkImages(new String[] {BenefitsSection.PRACTISE.getBenefitIcon(), BenefitsSection.CUSTOM.getBenefitIcon(),
//                BenefitsSection.MULTI.getBenefitIcon(), BenefitsSection.BASE.getBenefitIcon()});
//
//        //step 8: assert there are 4 texts below 4 images
//        indexPage.checkImagesTexts(new String[] {BenefitsSection.PRACTISE.getBenefitText(), BenefitsSection.CUSTOM.getBenefitText(),
//                BenefitsSection.MULTI.getBenefitText(), BenefitsSection.BASE.getBenefitText()});
//
//        //step 9: assert main headers texts
//        indexPage.checkHeaderTexts(IndexPageTexts.MAIN_TITLE.getText(), IndexPageTexts.JDI_TEXT.getText());
//
//        //step 10: assert iframe exists in the center of the page
//        indexPage.checkIFrame();
//
//        //step 11: assert there is EPAM logo in the left-top corner in the iframe
//        indexPage.checkIFrameLogo();
//
//        //step 12: switch to original window back (from iframe)
//        indexPage.goToOriginWindow();
//
//        //step 13: assert sub header text
//        indexPage.checkSubHeaderText(IndexPageTexts.SUB_HEADER);
//
//        //step 14: assert 'JDI GITHUB' is a link and its URL = https://github.com/epam/JDI
//        indexPage.checkGitLink(IndexPageTexts.SUB_HEADER);
//
//        //step 15: assert there is left section
//        indexPage.checkLeftSection();
//
//        //step 16: assert there is footer
//        indexPage.checkFooter();
    }
}
