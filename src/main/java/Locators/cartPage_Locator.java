package Locators;

import org.openqa.selenium.By;

public class cartPage_Locator {
    public static final By CartButton = By.xpath("(//div[@class='a-row a-spacing-top-small']//input[@class='a-button-input'])[1]");
    public static final By ProductNamesInCart = By.xpath("//div[@data-name='Active Items']//span[@class='a-truncate-cut']");

}
