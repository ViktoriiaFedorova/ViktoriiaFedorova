package hw4;

import base.hw4.DatesPage;
import base.hw4.IndexPageSelenide;
import base.hw4.SelenideBase;
import com.codeborne.selenide.testng.SoftAsserts;
import enums.IndexPageTexts;
import enums.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static base.hw4.DatesPage.leftSliderHandle;
import static base.hw4.DatesPage.rightSliderHandle;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

@Listeners({SoftAsserts.class})
public class TestForSlidersOnDatesPage extends SelenideBase {

    private IndexPageSelenide indexPageSelenide;

    //step 1: open test site by URL https://epam.github.io/JDI/
    @BeforeMethod
    public void initTest(){
        indexPageSelenide = open("https://epam.github.io/JDI/index.html", IndexPageSelenide.class);
    }

    @AfterMethod
    //close browser
    public void finishTest(){
        close();
    }

    @Test
    public void testForSlidersOnDatesPages(){

        DatesPage datesPage;

        //step 2: assert browser title
        indexPageSelenide.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 3: perform login
        indexPageSelenide.login(Users.PITERCHAILOVSKII);

        //step 4: assert user is logged in(check user name in the left - top corner)
        indexPageSelenide.checkUserLogIn(Users.PITERCHAILOVSKII);

        //step 5: open Service -> Dates page from header
        datesPage = indexPageSelenide.openDatesPagefromHeader();

        //step 6: set Range sliders: left is on the most left position, right - the most right position
        datesPage.setSliderHandleToPosition(leftSliderHandle, 0);
        datesPage.setSliderHandleToPosition(rightSliderHandle, 100);

        //step 7: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        datesPage.checkLogForSliderHandlePosition(leftSliderHandle, 0);
        datesPage.checkLogForSliderHandlePosition(rightSliderHandle, 100);

        //step 8: set Range sliders: left is on the most left position, right - the most left position
        datesPage.setSliderHandleToPosition(leftSliderHandle, 0);
        datesPage.setSliderHandleToPosition(rightSliderHandle, 0);

        //step 9: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        datesPage.checkLogForSliderHandlePosition(leftSliderHandle, 0);
        datesPage.checkLogForSliderHandlePosition(rightSliderHandle, 0);

        //step 10: set Range sliders: left is on the most right position, right - the most right position
        datesPage.setSliderHandleToPosition(rightSliderHandle, 100);
        datesPage.setSliderHandleToPosition(leftSliderHandle, 100);

        System.out.println("log1");

        //step 11: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        datesPage.checkLogForSliderHandlePosition(rightSliderHandle, 100);
        datesPage.checkLogForSliderHandlePosition(leftSliderHandle, 100);

        System.out.println("log2");

        //step 12: set Range sliders: left is 30, right is 70
        datesPage.setSliderHandleToPosition(leftSliderHandle, 30);
        datesPage.setSliderHandleToPosition(rightSliderHandle, 70);

        System.out.println("log3");

        //step 13: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        datesPage.checkLogForSliderHandlePosition(leftSliderHandle, 30);
        datesPage.checkLogForSliderHandlePosition(rightSliderHandle, 70);

        System.out.println("log");

    }

}
