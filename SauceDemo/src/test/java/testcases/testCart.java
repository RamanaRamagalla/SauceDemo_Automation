package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCart extends BaseTest{
	
	@Test(priority = 1)
	public void testCartPageUrl() {
		String expected = "https://www.saucedemo.com/cart.html";
		String actual = cart.getCartUrl();
		Assert.assertEquals(actual, expected, "Failed to load Cart page!");
	}
	@Test(priority = 2)
	public void testRemoveProduct() {
		int expected = 5;
		int actual = cart.removeProduct();
		Assert.assertEquals(actual, expected,"Remove button Failed!");
	}
	
	@Test(priority = 3)
	public void testContinueShoppingButton() {
		cart.getBackToShopping();
		String expected = "https://www.saucedemo.com/inventory.html";
		String actual = cart.getCartUrl();
		Assert.assertEquals(actual, expected, "Continue Shopping Button Failed!");
	}
	
	@Test(priority = 4)
	public void testCheckOutButton() {
		cart.goToCheckOut();
		String expected = "https://www.saucedemo.com/checkout-step-one.html";
		String actual = cart.getCartUrl();
		Assert.assertEquals(actual, expected, "Check Out Button is Failed!");
	}
}
