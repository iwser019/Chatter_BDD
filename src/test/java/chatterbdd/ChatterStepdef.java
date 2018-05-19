package chatterbdd;

import chatterbdd.Chatter;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;

public class ChatterStepdef {

    private Chatter chatter;
    private String saying;
    private String answer;
    private HashMap<String, String> exMatchBase;

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

    @When("^I need an exact match support$")
    public void iNeedAnExactMatchSupport() throws Throwable {
        this.exMatchBase = new HashMap<>();
    }

    @And("^I define an exact match like \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iDefineAnExactMatchLikeWith(String arg0, String arg1) throws Throwable {
        this.exMatchBase.put(arg0, arg1);
    }

    @And("^I set these exact matches up$")
    public void iSetTheseExactMatchesUp() throws Throwable {
        this.chatter.setExactMatchBase(this.exMatchBase);
    }

    @Then("^The program should have the same exact matches as set before$")
    public void theProgramShouldHaveTheSameExactMatchesAsSetBefore() throws Throwable {
        HashMap exMatchBaseNew = this.chatter.getExactMatchBase();
        boolean ok = true;
        ok &= Arrays.equals(exMatchBaseNew.keySet().toArray(),
                exMatchBase.keySet().toArray());
        if (ok) {
            for (Object str : exMatchBase.keySet().toArray()) {
                ok &= exMatchBaseNew.get(str).equals(exMatchBase.get(str));
            }
        }
        Assert.assertTrue(ok);
    }


    @Then("^The program should have the exact match for saying like \"([^\"]*)\"$")
    public void theProgramShouldHaveTheExactMatchForSayingLike(String arg0) throws Throwable {
        Assert.assertTrue(chatter.hasExactMatch(arg0));
    }
}
