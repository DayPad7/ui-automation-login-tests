package com.practicetestautomation.driver;
import com.practicetestautomation.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver create() {
        String browser = TestConfig.browser();

        if ("edge".equals(browser)) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver(edgeOptions());
        }

        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions());
        }

        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1440,900");
        if (TestConfig.headless()) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    private static EdgeOptions edgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1440,900");
        if (TestConfig.headless()) {
            options.addArguments("--headless=new");
        }
        return options;
    }
}

 