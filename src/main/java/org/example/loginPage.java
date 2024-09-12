package org.example;

import Locators.loginPage_Locator;
import Utils.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class loginPage extends AbstractClass {
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }
 
    public void openSigninpopup() {
        WebElement signin = driver.findElement(loginPage_Locator.signInpopup);
        signin.click();
    }
    public void validId(String email, String pass) throws InterruptedException {
        WebElement addEmail = driver.findElement(loginPage_Locator.addEmail);
        addEmail.sendKeys(email);
        WebElement continuebutton = driver.findElement(loginPage_Locator.continueButton);
        continuebutton.click();
        Thread.sleep(2000);
        WebElement password = driver.findElement(loginPage_Locator.addPassword);
        password.sendKeys(pass);
        driver.findElement(loginPage_Locator.signInSubmit).click();
    }

    /*public void InvalidEmail() throws InterruptedException {
        WebElement addEmail = driver.findElement(loginPage_Locator.addEmail);
        addEmail.sendKeys("0000000000");
        WebElement continuebutton = driver.findElement(loginPage_Locator.continueButton);
        continuebutton.click();

    }

    public void InvalidPass() throws InterruptedException {
        WebElement addEmail = driver.findElement(loginPage_Locator.addEmail);
        addEmail.sendKeys("9979259765");
        WebElement continuebutton = driver.findElement(loginPage_Locator.continueButton);
        continuebutton.click();
        Thread.sleep(2000);

        WebElement password = driver.findElement(loginPage_Locator.addPassword);
        password.sendKeys("Password");
        driver.findElement(loginPage_Locator.signInSubmit).click();
    }*/

}