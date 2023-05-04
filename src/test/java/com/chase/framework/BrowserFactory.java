package com.chase.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory class that creates the driver specific to browser
 */
public class BrowserFactory {

    private BrowserFactory() {}

    public static WebDriver getDriver() {
        WebDriver driver = null;

        //Expects the environment variable 'browser' to be set
        String browser = System.getProperty("browser","Chrome");

        if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("chrome")) {
          //  var options = new ChromeOptions();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
             driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            //Defaults to Chrome browser
            driver = new ChromeDriver(getChromeOptions());
        }

        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        return options;
    }
}
