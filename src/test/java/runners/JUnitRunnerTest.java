package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"cucumber"},
        features = {"src/test/resources/cucumber"}
)
public class JUnitRunnerTest {
}
