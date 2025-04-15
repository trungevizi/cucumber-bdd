package cucumber.pages;

import cucumber.domainobjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstNameField;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameField;

    @FindBy(id = "billing_country")
    private WebElement country;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressField;

    @FindBy(id = "billing_city")
    private WebElement cityField;

    @FindBy(id = "billing_state")
    private WebElement stateField;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeField;

    @FindBy(id = "billing_email")
    private WebElement emailField;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(className = "woocommerce-notice")
    private WebElement notice;

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public void enterBillingDetails(BillingDetails billingDetails) {
        this.enterFirstName(billingDetails.getFirstName())
                .enterLastName(billingDetails.getLastName())
                .selectCountry(billingDetails.getCountry())
                .enterAddress(billingDetails.getAddress())
                .enterCity(billingDetails.getCity())
                .selectState(billingDetails.getState())
                .enterPostcode(billingDetails.getPostcode())
                .enterEmail(billingDetails.getEmail());
    }

    public CheckoutPage enterFirstName(String firstName) {
        WebElement e = this.wait.until(ExpectedConditions.visibilityOf(firstNameField));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        WebElement e = this.wait.until(ExpectedConditions.visibilityOf(lastNameField));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddress(String address) {
        WebElement e = this.wait.until(ExpectedConditions.visibilityOf(billingAddressField));
        e.clear();
        e.sendKeys(address);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        WebElement e = this.wait.until(ExpectedConditions.visibilityOf(cityField));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostcode(String postcode) {
        WebElement e = this.wait.until(ExpectedConditions.visibilityOf(postcodeField));
        e.clear();
        e.sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterEmail(String email) {
        WebElement e = this.wait.until(ExpectedConditions.visibilityOf(emailField));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutPage selectCountry(String country) {
        Select selectCountry = new Select(this.country);
        selectCountry.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage selectState(String state) {
        Select selectState = new Select(stateField);
        selectState.selectByVisibleText(state);
        return this;
    }

    public void clickPlaceOrderButton() {
        this.waitOverlayToDisappear(overlay);
        this.wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public String getNoticeText() {
        return this.wait.until(ExpectedConditions.visibilityOf(notice)).getText();
    }

}
