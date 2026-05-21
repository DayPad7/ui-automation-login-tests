package com.practicetestautomation.tests;

import com.practicetestautomation.config.TestConfig;
import com.practicetestautomation.driver.DriverFactory;
import com.practicetestautomation.support.WebDriverHolder;
import com.practicetestautomation.support.ScreenshotOnFailureExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(ScreenshotOnFailureExtension.class)
public abstract class BaseTest {

    protected WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = DriverFactory.create();
        WebDriverHolder.set(webDriver);
    }

    @AfterEach
    void tearDown() {
        pauseForVisualReview();
        if (webDriver != null) {
            webDriver.quit();
        }
        WebDriverHolder.clear();
    }

    private void pauseForVisualReview() {
        if (webDriver == null || TestConfig.headless()) {
            return;
        }

        long pauseMillis = TestConfig.demoPauseMillis();
        if (pauseMillis <= 0L) {
            return;
        }

        try {
            Thread.sleep(pauseMillis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
 