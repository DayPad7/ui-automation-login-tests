package com.practicetestautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardScreen extends BaseScreen {

    private static final By SUCCESS_TITLE = By.className("post-title");
    private static final By LOGOUT_LINK = By.linkText("Log out");

    public DashboardScreen(WebDriver driver) {
        super(driver);
    }

    public void waitUntilLoaded() {
        waitForUrlContains("/logged-in-successfully/");
    }

    public String successMessage() {
        return getText(SUCCESS_TITLE);
    }

    public boolean isLogoutVisible() {
        return isVisible(LOGOUT_LINK);
    }
}
 