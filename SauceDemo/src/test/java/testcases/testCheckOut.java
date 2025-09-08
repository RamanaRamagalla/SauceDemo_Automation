package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testCheckOut extends BaseTest {

    @Test(priority = 1)
    public void testMandatoryFieldsValidation() {
        chkout.enterCheckoutInfo("", "", ""); // empty fields
        chkout.clickContinue();

        Assert.assertTrue(chkout.getErrorMsg().contains("First Name is required"),
                "Error message not shown for missing fields!");
    }

    @Test(priority = 2)
    public void testValidCheckoutNavigatesToOverview() {
        chkout.enterCheckoutInfo("John", "Doe", "12345");
        chkout.clickContinue();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-two.html"),
                "Did not navigate to checkout overview!");
    }

    @Test(priority = 3)
    public void testItemDetailsOnOverview() {
        String itemName = chkout.getItemName();
        String itemPrice = chkout.getItemPrice(); // ✅ fixed

        Assert.assertNotNull(itemName, "Item name missing in overview!");
        Assert.assertTrue(itemPrice.startsWith("$"), "Item price not displayed correctly!");
    }

    @Test(priority = 4)
    public void testCheckoutCompletion() {
        chkout.clickFinish();
        String header = chkout.getCompleteHeader();

        Assert.assertEquals(header, "Thank you for your order!", "Checkout not completed successfully!");
    }
}
