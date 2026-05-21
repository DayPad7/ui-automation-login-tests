package com.practicetestautomation.domain;

public class LoginExpectation {

    private final String scenarioName;
    private final String username;
    private final String password;
    private final boolean shouldSucceed;
    private final String expectedUrlContains;
    private final String expectedMessage;

    public LoginExpectation(String scenarioName, String username, String password, boolean shouldSucceed,
                            String expectedUrlContains, String expectedMessage) {
        this.scenarioName = scenarioName;
        this.username = username;
        this.password = password;
        this.shouldSucceed = shouldSucceed;
        this.expectedUrlContains = expectedUrlContains;
        this.expectedMessage = expectedMessage;
    }
 
    public String getScenarioName() {
        return scenarioName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean shouldSucceed() {
        return shouldSucceed;
    }

    public String getExpectedUrlContains() {
        return expectedUrlContains;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    @Override
    public String toString() {
        return scenarioName;
    }
}
