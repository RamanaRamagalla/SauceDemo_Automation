package pages;

import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelPOI;

public class AuthenticationPage {
	
	WebDriver driver;
	ExcelPOI excel = new ExcelPOI("src/test/resources/testdata/credentials.xlsx",0);
	//constructor
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private By user = By.id("user-name");
	private By pass = By.id("password");
	private By btn = By.id("login-button");
	//data retrieval
	private HashMap<String,String> dataMap= excel.getData();

	//Actions
	public  String validUserLogin(String url) {
		String username = dataMap.get("username");
		String password = dataMap.get("password");
		System.out.println("username :"+username+"password"+password);
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(user)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn)).click();
		return driver.getCurrentUrl();
	}
	public String inValidUsernameLogin(String url) {
		String username = "dummy_username";
		String password = dataMap.get("password");
		
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(user)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn)).click();
		return driver.getCurrentUrl();
	}
	public String invalidPasswordLogin(String url) {
		String username = dataMap.get("username");
		String password = "dummy_password";
		
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(user)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn)).click();
		return driver.getCurrentUrl();
	}
	//----------
	public boolean isLoginButtonDisplayed() {
	    return driver.findElement(btn).isDisplayed();
	}

	public boolean isOnProductsPage() {
	    return driver.getCurrentUrl().contains("inventory");
	}

	public void enterUsername(String username) {
	    driver.findElement(user).sendKeys(username);
	}

	public void enterPassword(String password) {
	    driver.findElement(pass).sendKeys(password);
	}

	public void clickLogin() {
	    driver.findElement(btn).click();
	}

}
