package hw4;

import base.hw4.IndexPageSelenide;
import base.hw4.SelenideBase;
import enums.IndexPageTexts;
import enums.Users;
import enums.hw4.ServicePageOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class TestForServicePage extends SelenideBase {

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

        //step 2: assert browser title
        indexPageSelenide.checkPageTitle(IndexPageTexts.PAGE_TITLE);

        //step 3: perform login
        indexPageSelenide.login(Users.PITERCHAILOVSKII);

        //step 4: assert user is logged in (check user name in the left-top corner)
        indexPageSelenide.checkUserLogIn(Users.PITERCHAILOVSKII);

        //step 5: click on 'Service' in the header and check dropdown contains options "Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"
        indexPageSelenide.checkServiceDropdownOptions(ServicePageOptions.serviceOptionsList());

        //step 6: click on 'Service' in the left section and check dropdown contains options "Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"
        //step 7: open Service -> Different Elements page from header
        //step 8: check Different Elements page contains 4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        //step 9: assert there is right section
        //step 10: assert there is left section
        //step 11: select checkboxes 'Water', 'Wind'
        //step 12: assert there are log rows for each checkbox and values correspond the checkboxes statuses (method should be parametrized)
        //step 13: select radio 'Selen'
        //step 14: assert there are log rows for each radio and values correspond the radios statuses (method should be parametrized)
        //step 15: select 'Yellow' in dropdown
        //step 16: assert there is log row for dropdown and value corresponds the selected value (method should be parametrized)
        //step 17: unselect checkboxes 'Water', 'Wind'
        //step 18: assert there are log rows for each checkbox and values corresponds the checkboxes statuses (method should be parametrized)

    }

}
