package Framework.ecommerce;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.PageObjects.CheckOutPage;
import Framework.PageObjects.ProductCatalogue;
import Framework.PageObjects.cartPage;
import Framework.PageObjects.orderStatus;
import Framework.PageObjects.ordersPage;
import Framework.testComponents.BaseTest;
import junit.framework.Assert;

public class SubmitOrderTest extends BaseTest {
	
	
	String productName = "ADIDAS ORIGINAL";
	String countryName = "India";
    @Test(dataProvider="getData",groups= {"Purchase"})
	public void EndToEndTest(HashMap<String,String> input) throws IOException, InterruptedException  
	{

		
		ProductCatalogue pc= lp.loginApplication(input.get("email"), input.get("password"));
		pc.getProductList();
		cartPage cp = pc.addProductToCart(input.get("productName"));
		
		boolean match = cp.verifyCart(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage co = cp.procedeToCheckOut();
		
		co.checkout(countryName);
		orderStatus os = co.submitOrder();
		
		String result = os.verifyOrder();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", result);
	

	}
    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException  
	{
		ProductCatalogue pc= lp.loginApplication("nshylendra1999@gmail.com", "Pass1234");
		pc.getProductList();
		cartPage cp = pc.addProductToCart(productName);
		boolean match = cp.verifyCart("ADIDAS ORILGINA");
		Assert.assertFalse(match);
	

	}
    @Test(dependsOnMethods={"EndToEndTest"})
    public void orderedItemValidation() throws InterruptedException
    {
    	ProductCatalogue pc= lp.loginApplication("nshylendra@gmail.com", "Pass1234");
		ordersPage op=pc.gotoOrdersPage();
		boolean matchFound = op.verifyorders(productName);
		Assert.assertTrue(matchFound);
	
    }
    
    @DataProvider
    public Object[][] getData() throws IOException
    {
    List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Framework\\data\\PurchaseOrder.json");
    return new Object[][] {{data.get(0)},{data.get(1)}};
    }


}
