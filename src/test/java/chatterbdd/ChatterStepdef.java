package chatterbdd;

import chatterbdd.Chatter;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.hu.Ha;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;

public class ChatterStepdef {

    private Chatter chatter;
    private String saying;
    private String answer;
    private HashMap<String, String> exMatchBase;
    private HashMap<String, String[]> typMatchBase;

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
        Assert.assertTrue("There are no exact matches for it", chatter.hasExactMatch(arg0));
    }

    @Then("^The program should not have the exact match for saying like \"([^\"]*)\"$")
    public void theProgramShouldNotHaveTheExactMatchForSayingLike(String arg0) throws Throwable {
        Assert.assertFalse("There's an exact match for it", chatter.hasExactMatch(arg0));
    }

    @Then("^The exact match for \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void theExactMatchForShouldBe(String arg0, String arg1) throws Throwable {
        Assert.assertEquals(arg1, chatter.getExactMatch(arg0));
    }

    @When("^I need a typical match support$")
    public void iNeedATypicalMatchSupport() throws Throwable {
        this.typMatchBase = new HashMap<>();
    }

    @And("^I define some typical phrases$")
    public void iDefineSomeTypicalPhrases() throws Throwable {
        this.typMatchBase.put("Не знаю.", new String[]{
                "Я тоже не знаю.",
                "А почему?",
                "Жаль."
        });
    }

    @And("^I set these typical phrases up$")
    public void iSetTheseTypicalPhrasesUp() throws Throwable {
        chatter.setTypicalMatchBase(typMatchBase);
    }

    @Then("^The program should have the same typical matches as set before$")
    public void theProgramShouldHaveTheSameTypicalMatchesAsSetBefore() throws Throwable {
        HashMap<String, String[]> typMatchBaseNew = chatter.getTypicalMatchBase();
        boolean ok = true;
        ok &= Arrays.equals(typMatchBase.keySet().toArray(),
                typMatchBaseNew.keySet().toArray());
        if (ok) {
            for (String str : typMatchBase.keySet()) {
                ok &= Arrays.equals(typMatchBase.get(str),
                        typMatchBaseNew.get(str));
            }
        }
        Assert.assertTrue("Typical match bases have mismatches", ok);
    }

    @Then("^The program should have a typical phrase match for the saying$")
    public void theProgramShouldHaveATypicalPhraseMatchForTheSaying() throws Throwable {
        Assert.assertTrue("There's no typical matches for it", chatter.hasTypicalMatch(saying));
    }

    @Then("^The program should not have a typical phrase match for the saying$")
    public void theProgramShouldNotHaveATypicalPhraseMatchForTheSaying() throws Throwable {
        Assert.assertFalse("There's an typical match for it", chatter.hasTypicalMatch(saying));
    }
}
