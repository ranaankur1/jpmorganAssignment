package com.chase.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

/**
 * Class that encapsulates Button
 */
public class Button {
    public static void click(By button) throws IOException {
        WebElement element = (new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(5)))
                .until(ExpectedConditions.presenceOfElementLocated(button));
        element.click();
        Helper.takeScreenshot("ButtonClicked");
    }

    public static void click(By button, int frameNo) throws IOException {
        Browser.getDriver().switchTo().frame(frameNo);
        WebElement element = (new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(button));
        element.click();
        Browser.getDriver().switchTo().defaultContent();
        Helper.takeScreenshot("ButtonClicked");
    }
}
