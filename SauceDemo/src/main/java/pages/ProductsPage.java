package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By sortDropDown = By.xpath("//select[@class='product_sort_container']");
    By productInvNames = By.xpath("//div[@class='inventory_item_name']");
    By productInvPrices = By.xpath("//div[@class='inventory_item_price']");
    By addToCartButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
    By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    By removeFromCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    // Filter low to high
    public boolean filterLowToHigh() {
        Select select = new Select(driver.findElement(sortDropDown));
        select.selectByVisibleText("Price (low to high)");

        List<WebElement> prices = driver.findElements(productInvPrices);
        for (int i = 0; i < prices.size() - 1; i++) {
            double first = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            double second = Double.parseDouble(prices.get(i + 1).getText().replace("$", ""));
            if (first > second) {
                return false; // If order is wrong
            }
        }
        return true;
    }

    // Add a single product (first product)
    public void addProduct() {
        driver.findElement(addToCartButton).click();
    }

    public void removeFromCart() {
    	driver.findElement(removeFromCartButton).click();
    }

    // Add multiple products
    public void addMultipleProducts() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (WebElement btn : buttons) {
            btn.click();
        }
    }

    // Get product name by index
    public String getProductName(int index) {
    	driver.findElement(cartBadge).click();
        return driver.findElements(productInvNames).get(index).getText();
    }

    // Get product price by index
    public String getProductPrice(int index) {
        return driver.findElements(productInvPrices).get(index).getText();
    }

    // Get cart badge count
    public int getCartBadgeCount() {
        try {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        } catch (Exception e) {
            return 0; // No products in cart
        }
    }
    //--------
    public boolean isProductTitleVisible() {
        return driver.findElement(productInvNames).isDisplayed();
    }

    public void sortProducts(String option) {
        Select select = new Select(driver.findElement(sortDropDown));
        select.selectByVisibleText(option);
    }

    public void addFirstProductToCart() {
        driver.findElements(addToCartButtons).get(0).click();
    }

    public void addMultipleProductsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < 3; i++) {
            buttons.get(i).click();
        }
    }


}
