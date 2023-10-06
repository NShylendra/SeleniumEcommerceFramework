package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.PageObjects.cartPage;
import Framework.PageObjects.ordersPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By visibility = By.cssSelector(".card-body b");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="div[class*='toast-error']")
	WebElement errorMsg;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orders;
	
	
	
	public void WaitForElementToAppear(By FindBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(visibility));
	}
	public void WaitForWebElementToAppear(WebElement errorMsg) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(errorMsg));
	}
	
	public void WaitForElementToDisappear()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	
	public cartPage gotoCartPage() throws InterruptedException
	{
		Thread.sleep(1000);
		cart.click();
		return new cartPage(driver);
	}
	
	public ordersPage gotoOrdersPage()
	{
		orders.click();
		return new ordersPage(driver);
	}
	
	


}
