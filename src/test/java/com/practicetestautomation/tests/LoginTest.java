package com.practicetestautomation.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.practicetestautomation.domain.LoginExpectation;
import com.practicetestautomation.domain.LoginRules;
import com.practicetestautomation.pages.DashboardScreen;
import com.practicetestautomation.pages.LoginScreen;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LoginTest extends BaseTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("loginScenarios")
    @DisplayName("Required login scenarios")
    void shouldValidateLoginBehavior(LoginExpectation expectation) {
        LoginScreen loginScreen = new LoginScreen(webDriver).open();

        loginScreen.login(expectation.getUsername(), expectation.getPassword());

        if (expectation.shouldSucceed()) {
            DashboardScreen dashboardScreen = new DashboardScreen(webDriver);
            dashboardScreen.waitUntilLoaded();

            assertThat(webDriver.getCurrentUrl()).contains(expectation.getExpectedUrlContains());
            assertThat(dashboardScreen.successMessage()).containsIgnoringCase("logged in successfully");
            assertThat(dashboardScreen.isLogoutVisible()).isTrue();
            return;
        }

        assertThat(loginScreen.isErrorVisible()).isTrue();
        assertThat(loginScreen.errorMessage()).isEqualTo(expectation.getExpectedMessage());
    }

    private static Stream<LoginExpectation> loginScenarios() {
        return Stream.of(
                LoginRules.evaluate("Test: Positive Login", "student", "Password123"),
                LoginRules.evaluate("Test: Negative username", "incorrectUser", "Password123"),
                LoginRules.evaluate("Test: Negative password", "student", "incorrectPassword")
        );
    }
}
 