package hw4;

import static com.codeborne.selenide.Selenide.*;
import base.hw4.DifferentElementsPage;
import org.testng.annotations.*;

import base.hw4.IndexPageSelenide;
import base.hw4.SelenideBase;
import enums.hw4.DifferentElementsTexts;
import enums.IndexPageTexts;
import enums.Users;

public class TestForServicePage extends SelenideBase {

    private IndexPageSelenide indexPageSelenide;
    private DifferentElementsPage differentElementsPage;

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
        //indexPageSelenide.checkServiceDropdownOptionsFromHeader
               //(Arrays.stream(ServicePageOptions.values()).map(ServicePageOptions::getText).toArray(String[]::new));

        //step 6: click on 'Service' in the left section and check dropdown contains options "Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"
        //indexPageSelenide.checkServiceDropdownOptionsFromLeftNav
               //(Arrays.stream(ServicePageOptions.values()).map(ServicePageOptions::getText).toArray(String[]::new));

        //step 7: open Service -> Different Elements page from header
        differentElementsPage = indexPageSelenide.openDifferentElementsFromHeader();
        differentElementsPage.checkDifferentElementsTitle(DifferentElementsTexts.PAGE_TITLE);

        //step 8: check Different Elements page contains 4 checkboxes, 4 radios, 1 dropdown, 2 buttons
        differentElementsPage.checkElements();

        //step 9: assert there is right section
        differentElementsPage.checkRightSection();

        //step 10: assert there is left section
        differentElementsPage.checkLeftSection();

        //step 11: select checkboxes 'Water', 'Wind'
        differentElementsPage.selectCheckboxes();

        //step 12: assert there are log rows for each checkbox and values correspond the checkboxes statuses (method should be parametrized)
        differentElementsPage.checkLog();

        //step 13: select radio 'Selen'
        //step 14: assert there are log rows for each radio and values correspond the radios statuses (method should be parametrized)
        //step 15: select 'Yellow' in dropdown
        //step 16: assert there is log row for dropdown and value corresponds the selected value (method should be parametrized)
        //step 17: unselect checkboxes 'Water', 'Wind'
        //step 18: assert there are log rows for each checkbox and values corresponds the checkboxes statuses (method should be parametrized)

    }

}
