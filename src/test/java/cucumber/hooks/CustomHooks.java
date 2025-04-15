package cucumber.hooks;

import cucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CustomHooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.initializeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
