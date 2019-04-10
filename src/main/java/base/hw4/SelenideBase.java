package base.hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public abstract class SelenideBase {

    @BeforeMethod
    public void beforeSuite() {

        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.screenshots = false;
//        Configuration.startMaximized = true;
    }
}
