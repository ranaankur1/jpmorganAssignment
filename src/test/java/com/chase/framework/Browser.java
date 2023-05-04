package com.chase.framework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Ankur Rana
 * Class that encapsulates Browser
 */
public class Browser {

    private static WebDriver driver = null;

    public static void navigateTo(String URL) throws IOException {
        if (driver == null) {
            driver = BrowserFactory.getDriver();
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        }

        driver.get(URL);
        driver.manage().window().maximize();
        Helper.takeScreenshot("OpenURL");
    }

    public static boolean elementExists(By element) throws InterruptedException {
        
        return !driver.findElements(element).isEmpty();
    }

    public static boolean elementExists(By element, int frame) throws InterruptedException {
        
        driver.switchTo().frame(frame);
        if (driver.findElements(element).isEmpty()) {
            driver.switchTo().defaultContent();
            return false;
        } else {
            driver.switchTo().defaultContent();
            return true;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void dispose() {
        driver.quit();
        driver = null;
    }
}