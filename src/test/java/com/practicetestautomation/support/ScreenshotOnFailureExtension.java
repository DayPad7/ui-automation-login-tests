package com.practicetestautomation.support;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotOnFailureExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WebDriver driver = WebDriverHolder.get();
        if (!(driver instanceof TakesScreenshot)) {
            return;
        }

        Path directory = Paths.get("target", "screenshots");
        String fileName = context.getDisplayName().replaceAll("[^a-zA-Z0-9-_\\.]", "_") + ".png";

        try {
            Files.createDirectories(directory);
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(source.toPath(), directory.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ignored) {
        }
    }
}
 