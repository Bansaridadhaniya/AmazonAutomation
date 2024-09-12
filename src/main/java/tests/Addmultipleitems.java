package tests;

import Utils.DriverFactory;
import org.example.homePage;
import org.example.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Addmultipleitems {
    WebDriver driver;
    loginPage login;
    homePage hp;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver();
        login = new loginPage(driver);
        hp = new homePage(driver);

    }
    @Test(dataProvider = "getLoginData")
    public void searchAndAddProductToCart (String email, String pass) throws InterruptedException {

        login.openSigninpopup();
        login.validId(email, pass);
        hp.searchSuggestionlisting("Remote");
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
