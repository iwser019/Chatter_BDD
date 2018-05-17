package chatterbdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/resources/chatterbdd"}
)
public class CucuRunner {
}
