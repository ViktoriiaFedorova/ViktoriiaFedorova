package hw4;

import base.hw4.DatesPage;
import base.hw4.IndexPageSelenide;
import base.hw4.SelenideBase;
import enums.IndexPageTexts;
import enums.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

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
    public void testForServicePage(){

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
        datesPage.setSliderHandlesToItsExtremes();

        //step 7: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        //step 8: set Range sliders: left is on the most left position, right - the most left position
        //step 9: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        //step 10: set Range sliders: left is on the most right position, right - the most right position
        //step 11: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)
        //step 12: set Range sliders: left is 30, right is 70
        //step 13: assert there are log rows for 'From' and 'To' sliders with corresponding values (method should be parametrized)

    }

}
