package cucumber.hooks;

import cucumber.context.TestContext;
import cucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class CustomHooks {
    private WebDriver driver;
    private final TestContext context;

    public CustomHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("BEFORE SCENARIO");
        System.out.println("Thread Id: " + Thread.currentThread().threadId());
        System.out.println("Scenario Id: " + scenario.getName());
        driver = DriverFactory.initializeDriver();
        this.context.driver = driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("BEFORE SCENARIO");
        System.out.println("Thread Id: " + Thread.currentThread().threadId());
        System.out.println("Scenario Id: " + scenario.getName());
        if (driver != null) {
            driver.quit();
        }
    }
}
