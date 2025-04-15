package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(css = "td[class='product-name'] a")
    private WebElement cartItem;

    @FindBy(css = "input[type='number']")
    private WebElement cartQuantity;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartItemText() {
        return this.wait.until(ExpectedConditions.visibilityOf(cartItem)).getText();
    }

    public int getCartQuantity() {
        String quantityText = this.wait.until(ExpectedConditions.visibilityOf(cartQuantity)).getAttribute("value");
        return Integer.parseInt(quantityText);
    }

}
