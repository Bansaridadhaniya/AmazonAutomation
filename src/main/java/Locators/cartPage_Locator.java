package Locators;

import org.openqa.selenium.By;

public class cartPage_Locator {
    public static final By AddToCartButton = By.id("nav-cart");
    //public static final By ProductNamesInCart = By.xpath("//div[@data-name='Active Items']/div/div/div/div/ul/li/a[contains(@class, 'sc-product-link')]");
    public static final By ProductNamesInCart = By.xpath("//div[@data-name='Active Items']//a[contains(@class, 'sc-product-link')]//span");

}
