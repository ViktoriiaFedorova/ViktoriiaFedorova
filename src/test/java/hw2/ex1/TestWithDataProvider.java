package hw2.ex1;

import base.IndexPage;
import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class TestWithDataProvider extends SeleniumBase {

    @DataProvider
    private Object[][] benefitTexts(){
        return new Object[][]{
                {"To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {"To be flexible and\n" + "customizable"},
                {"To be multiplatform"},
                {"Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"},
        };
    }

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

    @Test(dataProvider = "benefitTexts")
    public void checkBenefitTexts(String benefitText){
        System.out.println(benefitText);

        indexPage.open();
        indexPage.checkBenefitTexts((String) benefitText);
    }
}
