package org.example;

import Locators.cartPage_Locator;
import Utils.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    public void verifyProduct(String selectedProductName){
        List<WebElement> cartItems = driver.findElements(cartPage_Locator.ProductNamesInCart);
        boolean found = false;
        for (WebElement item : cartItems) {
            System.out.println("Cart Item Text: " + item.getText().trim());
            //String itemText = item.getText().replace("."," ");
            if (selectedProductName.contains(item.getText())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("✅ Product found in cart: " + selectedProductName);
        } else {
            System.out.println("❌ Product NOT found in cart: " + selectedProductName);
        }
    }
//    public WebElement getCartViewButton() {
//        return driver.findElement(cartPage_Locator.AddToCartButton); // Adjust as needed
//    }
}
