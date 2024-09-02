package org.example;

import Locators.homePage_Locator;
import Utils.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class homePage extends AbstractClass {
    private WebDriver driver;

    public homePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void searchForProduct(String productName){
        WebElement searchElement = driver.findElement(homePage_Locator.SEARCH_BOX);
        searchElement.sendKeys(productName);
        searchElement.submit();
    }
}
