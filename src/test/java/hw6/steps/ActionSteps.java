package hw6.steps;

import cucumber.api.java.en.When;

public class ActionSteps {

    //    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
//    public void iLoginAsUserWithPassword(String userName, String password){
//        new SelenideIndexPage().login(userName, password);
//    }

//    @When("^I login as user '([^\"]*)'$")
//    public void iLoginAsUser(User user){
//        new SelenideIndexPage().login(user);
//
//    }

    @When("^I login as user 'PITER_CHAILOVSKII'$")
    public void login(){}

    @When("^I select 'Water' and 'Wind' checkboxes$")
    public void selectCheckboxes(){}

    @When("^I select 'Selen' radio$")
    public void selectRadio(){}

    @When("^I select 'Yellow' in the dropdown$")
    public void selectDropdownValue(){}

    @When("^I unselect 'Water' and 'Wind' checkboxes$")
    public void unselectCheckboxes(){}
}
