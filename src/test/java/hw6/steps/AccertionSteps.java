package hw6.steps;

import cucumber.api.java.en.Then;
import static com.codeborne.selenide.Condition.text;

public class AccertionSteps {

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe (String expectedUserName){
//        new SelenideIndexPage().getUserName().shouldBe(text(expectedUserName));
    }

//    @Then("^User name should be as for user '([^\"]*)'$")
//    public void userNameShouldBeAsForUser (String user){
//        new SelenideIndexPage().getUserName().shouldBe(text(User.getUserByUserName(user).userName));
//    }
}
