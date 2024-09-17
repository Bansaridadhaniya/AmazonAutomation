package tests;

import Utils.DriverFactory;
import org.example.homePage;
import org.example.listingPage;
import org.example.loginPage;
import org.example.productPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Addmultipleitems {
    WebDriver driver;
    loginPage login;
    homePage hp;
    listingPage lp;
    productPage pp;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver();
        login = new loginPage(driver);
        hp = new homePage(driver);
        lp = new listingPage(driver);
        pp = new productPage(driver);
    }
    @Test(dataProvider = "getLoginData")
    public void searchAndAddProductToCart (String email, String pass) throws InterruptedException {

        login.openSigninpopup();
        login.validId(email, pass);
        hp.searchSuggestionlisting("Remote");
        lp.gotoProductDetail();
        pp.windowHandle();
        pp.addMultipleQuantity();
        pp.addToCartProduct();

    }
    @DataProvider(name = "getLoginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"9979259765", "Pransi@2903"}, // Valid credentials
                //{"abc", "abc"} // Invalid credentials
        };
    }
    /*@AfterMethod
    public void teardown() {
        // Close the browser after each test method
        if (driver != null) {
            driver.quit();
        }
    }*/
}
