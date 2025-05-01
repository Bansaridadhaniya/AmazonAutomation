package Locators;

import org.openqa.selenium.By;

public class listingPage_Locator {
    public static final By First_Product_Title_Link = By.xpath("(//div[@role='listitem']//div[@class='a-section a-spacing-small a-spacing-top-small']//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]");
    //listing detail page locators
    public static final By Product_Title = By.xpath("//div[@id='titleSection']//span");
    public static final By AddToCart_Button = By.xpath("(//form[@id='addToCart']//input[@type='submit'])[1]");
}
