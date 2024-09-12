package org.example;

import Locators.homePage_Locator;
import Utils.AbstractClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class homePage extends AbstractClass {
    private WebDriver driver;
    private WebDriverWait wait;


    public homePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void searchForProduct(String productName){
        WebElement searchElement = driver.findElement(homePage_Locator.SEARCH_BOX);
        searchElement.sendKeys(productName);
        searchElement.submit();
    }

    public void searchSuggestionlisting(String productName){
        WebElement searchElement1 = driver.findElement(homePage_Locator.SEARCH_BOX);
        searchElement1.sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage_Locator.LIST_ELEMENTS_OF_SEARCH));
        List<WebElement> searchresultlist = driver.findElements(homePage_Locator.LIST_ELEMENTS_OF_SEARCH);
        for(WebElement searchResult : searchresultlist){
            System.out.println(searchResult.getText());
            if(searchResult.getText().equalsIgnoreCase("remote control drone"))
            {
                WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(searchResult));
                clickableElement.click();
            }
        }
    }
}
