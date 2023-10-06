package Framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;
import dev.failsafe.internal.util.Assert;

public class cartPage extends AbstractComponent{
	
	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> item;
	
	@FindBy(css=".totalRow button")
	WebElement procede;
	
	public boolean verifyCart(String productName)
	{
		List <WebElement> cartProducts = item;

	    Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	    return match;

	   
	}
	
	public CheckOutPage procedeToCheckOut()
	{
		procede.click();
		return new CheckOutPage(driver);
		
	}


}
