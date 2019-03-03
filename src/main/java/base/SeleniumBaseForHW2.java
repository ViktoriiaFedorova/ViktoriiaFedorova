package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.*;

public abstract class SeleniumBaseForHW2 {

    private long testStart;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        testStart = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        out.println("⌛ Test duration: " + ((currentTimeMillis() - testStart)/1000) + " s");
    }
}
