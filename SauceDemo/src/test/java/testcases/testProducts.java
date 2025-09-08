package testcases;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelPOI;

public class testProducts extends BaseTest{

    ExcelPOI excel = new ExcelPOI("src/test/resources/testdata/expectedData.xlsx", 0);
    HashMap<String,String > dataMap = excel.getData();
    

    @Test(priority = 1)
    public void testFilterLowToHigh() {
        boolean isSorted = prod.filterLowToHigh();
        Assert.assertTrue(isSorted, "Filter Low to High failed!");
    }

    @Test(priority = 2)
    public void testAddSingleProduct() {
        prod.addProduct();
        Assert.assertEquals(prod.getCartBadgeCount(), 1, "Add single product failed!");
    }

    @Test(priority = 3)
    public void testAddMultipleProducts() {
    	prod.removeFromCart();
        prod.addMultipleProducts();
        Assert.assertEquals(prod.getCartBadgeCount(),6,"Adding multiple items failed!");
    }

    @Test(priority = 4)
    public void testProductDetails() {
        String name = prod.getProductName(0);
        String price = prod.getProductPrice(0);
        System.out.println("name"+name+"price"+price);
        Assert.assertNotNull(name, "Product name not found!");
        Assert.assertTrue(price.startsWith("$"), "Product price format incorrect!");
    }
}
