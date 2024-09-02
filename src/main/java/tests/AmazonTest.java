package tests;
import Locators.cartPage_Locator;
import Locators.listingPage_Locator;
import Utils.DriverFactory;
import org.example.cartPage;
import org.example.homePage;
import org.example.listingPage;
import org.example.loginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AmazonTest {
    private WebDriver driver;
    private loginPage login;
    private homePage hp;
    private listingPage lp;
    private cartPage cp;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
     driver = DriverFactory.createDriver();
     login = new loginPage(driver);
        hp = new homePage(driver);
        lp= new listingPage(driver);
        cp = new cartPage(driver);

        wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
    }
    @Test(dataProvider = "getLoginData")
    public void searchAndAddProductToCart (String email, String pass) throws InterruptedException {

        login.openSigninpopup();
        login.validId(email, pass);
        hp.searchForProduct("TV");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 1000)");
        lp.addToCartProduct();
        cp.viewCart();
    }

    @DataProvider(name = "getLoginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"9979259765", "Pransi@2903"}, // Valid credentials
                {"abc", "abc"} // Invalid credentials
        };
    }
    @AfterMethod
    public void teardown() {
        // Close the browser after each test method
        if (driver != null) {
            driver.quit();
        }
    }
}

