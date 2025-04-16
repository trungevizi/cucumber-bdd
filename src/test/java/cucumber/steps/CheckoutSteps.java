package cucumber.steps;

import cucumber.context.TestContext;
import cucumber.pages.CheckoutPage;
import cucumber.pages.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps {
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext testContext) {
        this.context = testContext;
        checkoutPage = PageFactory.getCheckoutPage(testContext.driver);
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

       checkoutPage.enterBillingDetails(this.context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals(checkoutPage.getNoticeText(), "Thank you. Your order has been received.", "Order was not placed successfully");
    }


}
