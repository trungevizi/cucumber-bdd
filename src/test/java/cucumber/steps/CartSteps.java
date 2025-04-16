package cucumber.steps;

import cucumber.context.TestContext;
import cucumber.domainobjects.BillingDetails;
import cucumber.domainobjects.Product;
import cucumber.pages.CartPage;
import cucumber.pages.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartSteps {
    private final TestContext context;
    private final CartPage cartPage;

    public CartSteps(TestContext context) {
        cartPage = PageFactory.getCartPage(context.driver);
        this.context = context;
    }

    @Then("I should see {int} {productTest} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getCartItemText(), "Product name does not match");
        Assert.assertEquals(quantity, cartPage.getCartQuantity(), "Product quantity does not match");
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.context.billingDetails = billingDetails;
    }

}
