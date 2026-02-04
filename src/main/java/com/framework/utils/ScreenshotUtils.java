package com.framework.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.driver.DriverFactory;

public class ScreenshotUtils {

	public static String capture(String testName) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String path = "reports/screenshots/" + testName + ".png";
            File dest = new File(path);
            src.renameTo(dest);

            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
