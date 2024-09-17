package Locators;

import org.openqa.selenium.By;

public class productPage_Locator {
    public static final By addQuantity = By.xpath("//div[@id='selectQuantity']//select[@class='a-native-dropdown a-declarative']");
    //public static final By addQuantity = By.xpath("//select[@id=’quantity’]");
    public static final By qualityDropDown = By.id("quantity");
    public static final By addToCartBtn = By.cssSelector("#add-to-cart-button");
}
