package base.hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

public abstract class SelenideBase {

    @BeforeTest
    public void beforeSuite() {

        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
        Configuration.screenshots = false;
    }
}
