package com.practicetestautomation.domain;

public final class LoginRules {

    private static final String SUCCESS_URL = "/logged-in-successfully/";
    private static final String SUCCESS_TEXT = "Logged In Successfully";
    private static final String INVALID_USERNAME = "Your username is invalid!";
    private static final String INVALID_PASSWORD = "Your password is invalid!";

    private LoginRules() {
    }

    public static LoginExpectation evaluate(String scenarioName, String username, String password) {
        if ("student".equals(username) && "Password123".equals(password)) {
            return new LoginExpectation(scenarioName, username, password, true, SUCCESS_URL, SUCCESS_TEXT);
        }

        if (!"student".equals(username)) {
            return new LoginExpectation(scenarioName, username, password, false, "", INVALID_USERNAME);
        }

        return new LoginExpectation(scenarioName, username, password, false, "", INVALID_PASSWORD);
    }
}

 