package cucumber.pages;

import cucumber.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(ConfigLoader.getInstance().getBaseURL() + url);
    }

    public void waitOverlayToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Overlays: " + overlays.size());
        if (!overlays.isEmpty()) {
            this.wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("Overlays disappeared");
        } else {
            System.out.println("No overlays found");
        }
    }
}
