package co.com.choucair.automation.android.stepdefinitions;

import co.com.choucair.automation.android.questions.VarifyWith;
import co.com.choucair.automation.android.tasks.Login;
import co.com.choucair.automation.android.tasks.OpenThe;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;


public class AuthenticationStepDefinitions {

    @Given("^that (.*) wants to enter the Wordpress application$")
    public void thatBrandonWantsToEnterTheWordpressApplication(String brandon) {
        OnStage.theActorCalled(brandon).wasAbleTo(OpenThe.wordpressApp());

    }

    @When("^I login with the username \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void iLoginWithTheUsernameAndThePassword(String user, String password) {
     OnStage.theActorInTheSpotlight().attemptsTo(Login.with(user,password));
    }

    @Then("^you should see the login in the application with the message (.*)$")
    public void youShouldSeeTheLoginInTheApplicationWithTheMessageLoggedInAs(String question) {
     OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VarifyWith.the(question)));
    }

}
