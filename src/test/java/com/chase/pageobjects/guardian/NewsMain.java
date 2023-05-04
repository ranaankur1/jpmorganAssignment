package com.chase.pageobjects.guardian;

import com.chase.framework.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Page object class specific to Guardian news main page
 */
public class NewsMain {
    private By heading = By.xpath("//p[contains(text(),'your choice')]");
    private By okButton = By.xpath("//button[text()='Yes, I’m happy']");
    private By newsSection = By.xpath("//div[contains(@data-link-name,'ad slot merchandising-high')]");
    private By newsLink = By.xpath("//a[@data-link-name='article' and @tabindex=-1]");

    private By choiceCardsBannerBlueClose = By.xpath("(//section[@data-target='choice-cards-banner-blue']//button)[1]");


    private String articleLink;

    public void navigateToHomePage(String url) throws IOException, InterruptedException {
        Browser.navigateTo(url);

        //Wait until the cookies frame loads
        if (Browser.elementExists(okButton, 1)) {
            //Accept the cookies
            Button.click(okButton, 1);
        }
    }

    public void userAccessesNewsUrl() throws IOException, InterruptedException {
        WebElement divElement = Section.getElement(newsSection);
        this.articleLink = Link.getAttribute(divElement, newsLink,"href");
        Link.click(divElement, newsLink);
        if (Browser.elementExists(okButton)) {
        	
            //Accept the cookies
            Button.click(okButton);
            System.out.println("ok button is click first time");
        }
   
    }

    public String getArticleLink() {
        return this.articleLink;
    }

    public void disposeBrowser() {
        Browser.dispose();
    }
}
