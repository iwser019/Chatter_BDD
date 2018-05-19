package chatterbdd;

import chatterbdd.Chatter;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ChatterStepdef {

    private Chatter chatter;
    private String saying;
    private String answer;

    @Given("^I have a chat program$")
    public void iHaveAChatProgram() throws Throwable {
        this.chatter = new Chatter();
    }

    @When("^I try to say nothing$")
    public void iTryToSayNothing() throws Throwable {
        this.answer = chatter.getAnswer(null);
    }

    @Then("^The program does not understand me$")
    public void theProgramDoesNotUnderstandMe() throws Throwable {
        Assert.assertEquals("Не понял.", this.answer);
    }

    @When("^I decided to ask something like \"([^\"]*)\"$")
    public void iDecidedToAskSomethingLike(String arg0) throws Throwable {
        this.saying = arg0;
    }

    @And("^I say what I want$")
    public void iSayWhatIWant() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.answer = chatter.getAnswer(saying);
    }

    @Then("^The program should give an answer like \"([^\"]*)\"$")
    public void theProgramShouldGiveAnAnswerLike(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(arg0, this.answer);
    }
}
