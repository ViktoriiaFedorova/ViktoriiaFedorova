package hw2.ex1;

import base.IndexPage;
import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestWithDataProvider extends SeleniumBase {
    private ThreadLocal<WebDriver> threads = new ThreadLocal<>();

    @DataProvider(parallel = true)
    private Object[][] benefitTexts(){
        return new Object[][]{
                {"icon-practise", "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {"icon-custom", "To be flexible and\n" + "customizable"},
                {"icon-multi", "To be multiplatform"},
                {"icon-base", "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"},
        };
    }

    private IndexPage indexPage;
    private WebDriver chromeDriver;

    @BeforeMethod
    public synchronized void initTest(){
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        indexPage = PageFactory.initElements(chromeDriver, IndexPage.class);
        threads.set(chromeDriver);
    }

    @AfterMethod
    //step 17: close browser
    public synchronized void finishTest() {
        threads.get().close();
    }

    @Test(dataProvider = "benefitTexts")
    public void checkBenefitTexts(String iconName, String benefitText){
        indexPage.open();
        indexPage.checkBenefitTexts(iconName, benefitText);
    }
}
