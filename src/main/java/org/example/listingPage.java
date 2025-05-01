package org.example;

import Utils.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Locators.listingPage_Locator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;


public class listingPage extends AbstractClass {
    WebDriver driver;
    public listingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String addToCartProduct() throws InterruptedException {
        WebElement productLink  = driver.findElement(listingPage_Locator.First_Product_Title_Link);
        String originalTab = driver.getWindowHandle(); // Store current tab
        productLink.click();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listingPage_Locator.Product_Title));
        WebElement productTitleElement = driver.findElement(listingPage_Locator.Product_Title);
        String productName = productTitleElement.getText().trim();
        System.out.println("product tile from detail page:" + productName);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 500)");
        wait.until(ExpectedConditions.elementToBeClickable(listingPage_Locator.AddToCart_Button));
        driver.findElement(listingPage_Locator.AddToCart_Button).click();
        Thread.sleep(5000);

        return productName;
    }
//    public String addToWishlistProduct(){
//
//    }
}
