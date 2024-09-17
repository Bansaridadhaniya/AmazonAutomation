package org.example;

import Utils.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Locators.listingPage_Locator;


public class listingPage extends AbstractClass {
    WebDriver driver;
    public String selectedProductName;
    public listingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By addtocart = By.id("nav-cart");


    public String addToCartProduct(){
        WebElement productNameElement = driver.findElement(listingPage_Locator.Selected_Product_name);
        selectedProductName = productNameElement.getText();
        System.out.println("this is my clicked product:" + selectedProductName);

        WebElement addtocartbtn = driver.findElement(listingPage_Locator.First_item);
        addtocartbtn.click();

        waitforElementToAppear(addtocart);
        return selectedProductName;
    }


    /*public void gotoProductDetail(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,500)");
        WebElement productDetail = driver.findElement(listingPage_Locator.Selected_Product_name);
        productDetail.click();
    }*/
}
