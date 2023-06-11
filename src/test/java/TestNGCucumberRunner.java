import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/mailTravel.feature",
        glue = "StepDef",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}



