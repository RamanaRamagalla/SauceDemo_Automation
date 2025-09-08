package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import config.Config;

public class testAuthentication extends BaseTest{
	
	@Test(priority = 1)
	public void testInvalidPasswordLogin() {
		String actual = auth.invalidPasswordLogin(Config.url);
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual,expected,"Login Succeeded : Test failed!" );
	}
	
	@Test(priority = 2)
	public void testInvalidUsernameLogin() {
		String actual = auth.inValidUsernameLogin(Config.url);
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual,expected,"Login Succeeded : Test failed!" );
	}
	
	@Test(priority = 3)
	public void testValidUserLogin() {
		String actual = auth.validUserLogin(Config.url);
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual,expected,"Login Failed!" );
	}

}
