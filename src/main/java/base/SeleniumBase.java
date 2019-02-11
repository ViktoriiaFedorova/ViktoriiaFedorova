package base;

import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println();
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }
}
