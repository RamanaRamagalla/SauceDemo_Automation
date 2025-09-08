package testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import config.Config;
import pages.AuthenticationPage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ProductsPage;

public class BaseTest {
    public static WebDriver driver;
    protected static AuthenticationPage auth;
    protected static ProductsPage prod;
	protected static CartPage cart;
	protected static CheckOutPage chkout;
	
	
    @BeforeSuite
    public void setup() {
        if (driver == null) {   
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(Config.url);
            auth = new AuthenticationPage(driver);
            prod = new ProductsPage(driver);
        	cart = new CartPage(driver);
        	chkout = new CheckOutPage(driver);
        }
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();   
        }
    }
}
