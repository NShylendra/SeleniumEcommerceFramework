package Framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	By visibility = By.cssSelector(".card-body b");
	
	
	public List<WebElement> getProductList()
	{
		return products;
	}

	public WebElement getProductByName(String productName)
	{
		WaitForElementToAppear(visibility);
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector(".card-body b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public cartPage addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		gotoCartPage();
		return new cartPage(driver);
	}
	
	
	

}
