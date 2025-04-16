package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        },
        snippets = io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
        glue = {"cucumber"},
        features = {"src/test/resources/cucumber"}
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
