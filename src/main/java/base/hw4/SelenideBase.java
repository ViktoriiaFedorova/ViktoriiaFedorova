package base.hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class SelenideBase {

//    @BeforeMethod
    public void beforeSuite() {
//        System.out.println("beforeSuite");
//        Configuration.browser = Browsers.CHROME;
//        Configuration.timeout = 30000;
//        Configuration.pollingInterval = 300;
//        Configuration.screenshots = false;
//        Configuration.startMaximized = true;
    }
}
