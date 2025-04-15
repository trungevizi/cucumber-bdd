package cucumber.steps;

import cucumber.constants.Endpoint;
import cucumber.domainobjects.BillingDetails;
import cucumber.domainobjects.Product;
import cucumber.factory.DriverFactory;
import cucumber.pages.CartPage;
import cucumber.pages.CheckoutPage;
import cucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddCartSteps {
    private WebDriver webDriver;
    private BillingDetails billingDetails;

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        webDriver = DriverFactory.getDriver();
        new StorePage(webDriver).open(Endpoint.STORE.url);
    }

    @When("I add a {productTest} to the cart")
    public void iAddAToTheCart(Product product) {
        new StorePage(webDriver).addToCart(product.getName());
    }

    @Then("I should see {int} {productTest} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        CartPage cartPage = new CartPage(webDriver);
        Assert.assertEquals("Product name does not match", product.getName(), cartPage.getCartItemText());
        Assert.assertEquals("Product quantity does not match", quantity, cartPage.getCartQuantity());
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        webDriver = DriverFactory.getDriver();
        new StorePage(webDriver).open(Endpoint.STORE.url);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @And("I have an product on the cart")
    public void iHaveAnProductOnTheCart() {
        new StorePage(webDriver).addToCart("Blue Shoes");
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        new StorePage(webDriver).clickCheckoutButton();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
//        WebElement firstNameField = webDriver.findElement(By.id("billing_first_name"));
//        WebElement lastNameField = webDriver.findElement(By.id("billing_last_name"));
//        WebElement country = webDriver.findElement(By.id("billing_country"));
//        Select selectCountry = new Select(country);
//        selectCountry.selectByVisibleText(billingDetails.getFirst().get("country"));
//        WebElement addressField = webDriver.findElement(By.id("billing_address_1"));
//        WebElement cityField = webDriver.findElement(By.id("billing_city"));
//        WebElement stateField = webDriver.findElement(By.id("billing_state"));
//        Select selectState = new Select(stateField);
//
//        selectState.selectByVisibleText(billingDetails.getFirst().get("state"));
//        WebElement postcodeField = webDriver.findElement(By.id("billing_postcode"));
//        WebElement emailField = webDriver.findElement(By.id("billing_email"));
//
//
//        firstNameField.sendKeys(billingDetails.getFirst().get("firstname"));
//        lastNameField.sendKeys(billingDetails.getFirst().get("lastname"));
//        selectCountry.selectByVisibleText(billingDetails.getFirst().get("country"));
//        addressField.clear();
//        addressField.sendKeys(billingDetails.getFirst().get("address_line1"));
//        cityField.clear();
//        cityField.sendKeys(billingDetails.getFirst().get("city"));
//
//        postcodeField.clear();
//        postcodeField.sendKeys(billingDetails.getFirst().get("zip"));
//
//        emailField.clear();
//        emailField.sendKeys(billingDetails.getFirst().get("email"));

        new CheckoutPage(webDriver).enterBillingDetails(this.billingDetails);

    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(webDriver).clickPlaceOrderButton();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        String noticeText = new CheckoutPage(webDriver).getNoticeText();
        Assert.assertEquals("Order was not placed successfully", "Thank you. Your order has been received.", noticeText);
    }

}
