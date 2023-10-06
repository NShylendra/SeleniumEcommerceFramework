package Framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="input[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".ta-item.list-group-item.ng-star-inserted:last-of-type")
	WebElement select;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submitOrder;
	
	
	
	
	public void checkout(String country)
	{
		Actions ac = new Actions(driver);
		ac.sendKeys(selectCountry,country).build().perform();
		select.click();
		
	}
	public orderStatus submitOrder() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(1000);
		submitOrder.click();
		return new orderStatus(driver);
	}

    
	

}
