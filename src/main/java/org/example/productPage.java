package org.example;

import Locators.homePage_Locator;
import Locators.productPage_Locator;
import Utils.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class productPage extends AbstractClass{
    private WebDriver driver;
    private WebDriverWait wait;


    public productPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void windowHandle(){
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }
    public void addMultipleQuantity(){
        try{
            System.out.println("added into quantity method");

            WebElement quantityDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(productPage_Locator.addQuantity));
            Select quantityValue = new Select(quantityDropdown);
            quantityValue.selectByValue("4");
            WebElement quantityInput = driver.findElement(productPage_Locator.addQuantity);
            wait.until(ExpectedConditions.attributeToBe(quantityInput,"value","4"));
            }
        catch (Exception e){

        }
     }

    public void addToCartProduct() {
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(productPage_Locator.addToCartBtn));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
            addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(productPage_Locator.addToCartBtn));
            addToCartButton.click();
            System.out.println("Product added to cart successfully");
        } catch (Exception e)
        {
            System.err.println("Error adding product to cart: " + e.getMessage());
        }
    }
}
