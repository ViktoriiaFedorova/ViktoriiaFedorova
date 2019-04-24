package hw6.steps;

import cucumber.api.java.en.Then;

public class AssertionSteps {

//    @Then("^User name should be as for user '([^\"]*)'$")
//    public void userNameShouldBeAsForUser (String user){
//        new SelenideIndexPage().getUserName().shouldBe(text(User.getUserByUserName(user).userName));
//    }

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe (String expectedUserName){
//        new SelenideIndexPage().getUserName().shouldBe(text(expectedUserName));
    }

    @Then("^There are needed elements on the page$")
    public void checkNeededElements(){}

    @Then("^There are log rows per each selected checkbox$")
    public void checkLogRowsForSelectedCheckboxes(){}

    @Then("^There is a log row for selected radio$")
    public void checkLogRowForRadio(){}

    @Then("^There is a log row for selected value$")
    public void checkLogRowForDropdownValue(){}

    @Then("^There are log rows per each unselected checkbox$")
    public void checkLogRowsForUnselectedCheckboxes(){}
}
