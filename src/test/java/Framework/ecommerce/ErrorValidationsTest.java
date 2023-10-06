package Framework.ecommerce;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Framework.PageObjects.CheckOutPage;
import Framework.PageObjects.LandingPage;
import Framework.PageObjects.ProductCatalogue;
import Framework.PageObjects.cartPage;
import Framework.PageObjects.orderStatus;
import Framework.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ErrorValidationsTest extends BaseTest {
	
    @Test
	public void LoginErrorValidations() throws IOException, InterruptedException  
	{
		ProductCatalogue pc= lp.loginApplication("nshyldra@gmail.com", "Pass134");
		String errorMessege = lp.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.",errorMessege);
		
	}
    @Test
    public void passwordBlankErrorValidations()
	{
		ProductCatalogue pc = lp.errorPassword("nshylendra@gmail.com");
        String errorPasswordMessege = lp.getPasswordErrorMessage();
		Assert.assertEquals("*Password is required",errorPasswordMessege);
		
	}
   




}
