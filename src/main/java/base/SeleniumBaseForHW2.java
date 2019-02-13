package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBaseForHW2 {

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("test takes" + System.currentTimeMillis());
    }
}
