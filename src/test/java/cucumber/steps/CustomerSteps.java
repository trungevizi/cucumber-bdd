package cucumber.steps;

import cucumber.constants.Endpoint;
import cucumber.context.TestContext;
import cucumber.domainobjects.Product;
import cucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CustomerSteps {
    private final WebDriver webDriver;

    public CustomerSteps(TestContext testContext) {
        this.webDriver = testContext.driver;
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        new StorePage(webDriver).open(Endpoint.STORE.url);
    }

}
