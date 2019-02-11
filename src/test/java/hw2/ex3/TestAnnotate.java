package hw2.ex3;

import base.IndexPage;
import base.SeleniumBase;
import base.SeleniumBaseForHW2;
import enums.BenefitsSection;
import enums.HeaderItems;
import enums.IndexPageTexts;
import enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class TestAnnotate extends SeleniumBaseForHW2 {
    private IndexPage indexPage;
    private WebDriver chromeDriver;

    @BeforeClass
    public void initDriver(){
        chromeDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void initTest(){
        chromeDriver.manage().window().maximize();
        indexPage = PageFactory.initElements(chromeDriver, IndexPage.class);
    }

    @AfterMethod
    public void finishTest(){
        System.out.println(chromeDriver.getTitle());
    }

    @AfterClass
    public void finishClass(){
        chromeDriver.close();
    }

    @Test
    public  void test1(){

        //step 1: open test site by URL https://epam.github.io/JDI/
        indexPage.open();

        //step 2: assert browser title
        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 3: perform login
        indexPage.login(Users.PITERCHAILOVSKII);

        //step 4: assert user is logged in (check user name in the left-top corner)
        indexPage.checkUserLogIn(Users.PITERCHAILOVSKII);

        //step 5: assert browser title
        indexPage.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 6: assert there are 4 items ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS") displayed with proper texts on the header
        indexPage.checkHeaderItems(new String[] {HeaderItems.HOME.toString(), HeaderItems.CONTACT_FORM.toString(),
                        HeaderItems.SERVICE.toString(), HeaderItems.METALS_COLORS.toString()});

        //step 7: assert there are 4 images displayed
        indexPage.checkImages(new String[] {BenefitsSection.PRACTISE.getBenefitIcon(), BenefitsSection.CUSTOM.getBenefitIcon(),
                BenefitsSection.MULTI.getBenefitIcon(), BenefitsSection.BASE.getBenefitIcon()});

        //step 8: assert there are 4 texts below 4 images
        indexPage.checkImagesTexts(new String[] {BenefitsSection.PRACTISE.getBenefitText(), BenefitsSection.CUSTOM.getBenefitText(),
                BenefitsSection.MULTI.getBenefitText(), BenefitsSection.BASE.getBenefitText()});

        //step 9: assert main headers texts
        indexPage.checkHeaderTexts(IndexPageTexts.MAIN_TITLE.getText(), IndexPageTexts.JDI_TEXT.getText());

        //step 10: assert iframe exists in the center of the page
        indexPage.checkIFrame();

        //step 11: assert there is EPAM logo in the left-top corner in the iframe
        indexPage.checkIFrameLogo();

        //step 12: switch to original window back (from iframe)
        indexPage.goToOriginWindow();

        //step 13: assert sub header text
        indexPage.checkSubHeaderText(IndexPageTexts.SUB_HEADER);

        //step 14: assert 'JDI GITHUB' is a link and its URL = https://github.com/epam/JDI
        indexPage.checkGitLink(IndexPageTexts.SUB_HEADER);

        //step 15: assert there is left section
        indexPage.checkLeftSection();

        //step 16: assert there is footer
        indexPage.checkFooter();
    }
}
