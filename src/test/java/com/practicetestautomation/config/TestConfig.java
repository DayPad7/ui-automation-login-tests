package com.practicetestautomation.config;

public final class TestConfig {

    private static final String DEFAULT_BASE_URL = "https://practicetestautomation.com/practice-test-login/";
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String DEFAULT_HEADLESS = "true";
    private static final String DEFAULT_DEMO_PAUSE_MILLIS = "0";

    private TestConfig() {
    }

    public static String baseUrl() {
        return read("baseUrl", DEFAULT_BASE_URL);
    }

    public static String browser() {
        return read("browser", DEFAULT_BROWSER).toLowerCase();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(read("headless", DEFAULT_HEADLESS));
    }

    public static long demoPauseMillis() {
        return Long.parseLong(read("demoPauseMillis", DEFAULT_DEMO_PAUSE_MILLIS));
    }

    private static String read(String key, String defaultValue) {
        String value = System.getProperty(key, defaultValue);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }
}
