package base.hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SelenideBase {

    @BeforeSuite
    public void beforeSuite() {

        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
        Configuration.screenshots = false;
    }
}
