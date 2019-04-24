package hw6.steps;

import base.hw6.IndexPageBDD;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    private IndexPageBDD indexPage;

    private static final String INDEX_PAGE_URL = "https://epam.github.io/JDI/index.html";

    @Given("^I open EPAM JDI site$")
    public void openEpamJDIPage() {
        open(INDEX_PAGE_URL);
    }

    @Given("^There are needed elements on the Homepage$")
    public void checkElementsOnHomePage(){
    }

    @Given("^There are needed options under 'Service' in the header$")
    public void checkOptionsInHeader(){
    }

    @Given("^There are needed options under 'Service' in the left menu$")
    public void checkOptionsInLeftMenu(){
    }

    @Given("^I open Different Elements page from header$")
    public void openDifferentElementsPage(){
    }
}
