package definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.ProductsPage;

import java.time.Duration;

public class StepDefinitions {

    private WebDriver driver;
    private AuthenticationPage authPage;
    private ProductsPage productPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        authPage = new AuthenticationPage(driver);
        productPage = new ProductsPage(driver);
        Assert.assertTrue(authPage.isLoginButtonDisplayed(), "Login button not displayed");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        authPage.enterUsername(username);
        authPage.enterPassword(password);
    }

    @And("clicks login button")
    public void clicks_login_button() {
        authPage.clickLogin();
    }

    @Then("user should see products page")
    public void user_should_see_products_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(authPage.isOnProductsPage(), "Products page not displayed");
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        driver = DriverFactory.getDriver();
        productPage = new ProductsPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name']")));
        } catch (Exception e) {
            Assert.fail("Products not visible after login");
        }
        Assert.assertTrue(productPage.isProductTitleVisible(), "User not logged in / products not visible");
    }

    @When("user sorts products by {string}")
    public void user_sorts_products_by(String sortOption) {
        productPage.sortProducts(sortOption);
    }

    @And("adds first product to cart")
    public void adds_first_product_to_cart() {
        productPage.addFirstProductToCart();
    }

    @And("adds multiple products to cart")
    public void adds_multiple_products_to_cart() {
        productPage.addMultipleProductsToCart();
    }

    @Then("cart badge count should reflect the number of products added")
    public void cart_badge_count_should_reflect_number() {
        int count = productPage.getCartBadgeCount();
        Assert.assertTrue(count > 1, "Cart badge count incorrect");
    }
}
