package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
	By checkOutButton = By.xpath("//*[@id=\"checkout\"]");
	By RemoveBtn = By.xpath("//button[contains(text(),'Remove')]");
	By cartBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

	public String getCartUrl() {
		return driver.getCurrentUrl();
	}

	public void getBackToShopping() {
		driver.findElement(continueShoppingBtn).click();
	}
	
	public void goToCheckOut() {
		driver.findElement(cartBadge).click();
		driver.findElement(checkOutButton).click();
	}
	public int removeProduct() {
		driver.findElement(RemoveBtn).click();
		return Integer.parseInt(driver.findElement(cartBadge).getText());
	}
	//------
	public boolean isCartNotEmpty() {
	    return driver.findElements(cartBadge).size() > 0;
	}

	public void openCart() {
	    driver.findElement(cartBadge).click();
	}

	public boolean verifyCartDetails() {
	    return driver.findElements(RemoveBtn).size() > 0;
	}

	public boolean verifyRemainingItems() {
	    return driver.findElements(RemoveBtn).size() >= 1;
	}

	
}
