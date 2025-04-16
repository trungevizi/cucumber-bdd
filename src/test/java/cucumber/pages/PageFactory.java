package cucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static CartPage cartPage;
    private static StorePage storePage;
    private static CheckoutPage checkoutPage;

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static StorePage getStorePage(WebDriver driver) {
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver) {
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }
}
