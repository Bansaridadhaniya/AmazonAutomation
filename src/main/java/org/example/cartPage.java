package org.example;

import Locators.cartPage_Locator;
import Utils.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class cartPage extends AbstractClass {
    private WebDriver driver;
    public cartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void viewCart(){
        WebElement cartButton = driver.findElement(cartPage_Locator.AddToCartButton);
        cartButton.click();
    }
//    public WebElement getCartViewButton() {
//        return driver.findElement(cartPage_Locator.AddToCartButton); // Adjust as needed
//    }
}
