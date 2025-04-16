package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    @FindBy(xpath = "//a[@title='View cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//h1[normalize-space()='Store']")
    private WebElement storePageTitle;

    @FindBy(className = "checkout-button")
    private WebElement checkoutButton;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        this.wait.until(ExpectedConditions.visibilityOf(storePageTitle));
        WebElement addToCartButton = this.driver.findElement(By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']"));
        this.wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        this.wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
    }

    public void clickCheckoutButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }


}
