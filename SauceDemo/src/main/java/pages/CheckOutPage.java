package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
   WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By errorMsg = By.cssSelector("h3[data-test='error']");
    By itemName = By.className("inventory_item_name");
    By itemPrice = By.className("inventory_item_price");
    By completeHeader = By.className("complete-header");

    // Actions
    public void enterCheckoutInfo(String fname, String lname, String postal) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(fname);
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lname);
        driver.findElement(postalCodeField).clear();
        driver.findElement(postalCodeField).sendKeys(postal);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public String getCompleteHeader() {
        return driver.findElement(completeHeader).getText();
    }
    
    
}
