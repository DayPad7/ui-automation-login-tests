package com.practicetestautomation.pages;

import com.practicetestautomation.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen extends BaseScreen {

    private static final By USERNAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By SUBMIT = By.id("submit");
    private static final By ERROR = By.id("error");

    public LoginScreen(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginScreen open() {
        webDriver.get(TestConfig.baseUrl());
        return this;
    }

    public void login(String username, String password) {
        type(USERNAME, username);
        type(PASSWORD, password);
        click(SUBMIT);
    }

    public boolean isErrorVisible() {
        return isVisible(ERROR);
    }

    public String errorMessage() {
        return getText(ERROR);
    }
}
 