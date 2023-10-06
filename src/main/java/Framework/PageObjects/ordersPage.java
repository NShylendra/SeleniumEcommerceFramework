package Framework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ordersPage extends AbstractComponent {

	WebDriver driver;
	public ordersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=" tr td:nth-child(3)")
	List<WebElement> orderedItems;
	
	
	public boolean verifyorders(String productName)
	{
		List <WebElement> orderedProducts = orderedItems;
		
		boolean matchFound = orderedProducts.stream().anyMatch(orderedProduct->orderedProduct.getText().equalsIgnoreCase(productName));
		return matchFound;

	 

	}
}
