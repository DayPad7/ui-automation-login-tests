package com.practicetestautomation.support;

import org.openqa.selenium.WebDriver;

public final class WebDriverHolder {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    private WebDriverHolder() {
    }

    public static void set(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static WebDriver get() {
        return DRIVER.get();
    }

    public static void clear() {
        DRIVER.remove();
    }
}
 