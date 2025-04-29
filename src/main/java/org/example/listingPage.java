package org.example;

import Utils.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Locators.listingPage_Locator;


public class listingPage extends AbstractClass {
    WebDriver driver;
    public listingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By addtocart = By.id("nav-cart");

   // @FindBy (id= "a-autoid-2-announce")
    //WebElement firstitem;
    public void addToCartProduct(){
        WebElement product = driver.findElement(listingPage_Locator.First_item);
        product.click();

        waitforElementToAppear(addtocart);
    }

}
