package cucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}