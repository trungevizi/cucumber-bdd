package cucumber.steps;

import cucumber.constants.Endpoint;
import cucumber.context.TestContext;
import cucumber.domainobjects.Product;
import cucumber.pages.PageFactory;
import cucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreSteps {
    private final StorePage storePage;
    private TestContext testContext;

    public StoreSteps(TestContext testContext) {
        storePage = PageFactory.getStorePage(testContext.driver);
    }

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        storePage.open(Endpoint.STORE.url);
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        storePage.clickCheckoutButton();
    }

    @When("I add a {productTest} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }

    @And("I have an product on the cart")
    public void iHaveAnProductOnTheCart() {
        storePage.addToCart("Blue Shoes");
    }

}
