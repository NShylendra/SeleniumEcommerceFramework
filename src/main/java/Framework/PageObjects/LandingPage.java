package Framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="div[class*='toast-error']")
	WebElement errorMsg;
	
	@FindBy(css="div[class='invalid-feedback'] div")
	WebElement passwordErrorMsg;
	
	
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		return new ProductCatalogue(driver);
	}

	
	public String getErrorMessage()
	{
		WaitForWebElementToAppear(errorMsg);
		String errorMessege = errorMsg.getText();
		return errorMessege;
	}
	
	public ProductCatalogue errorPassword(String email)
	{
		userEmail.sendKeys(email);
		login.click();
		return new ProductCatalogue(driver);
		
	}
	
	public String getPasswordErrorMessage()
	{
		WaitForWebElementToAppear(passwordErrorMsg);
		String errorPasswordMessege = passwordErrorMsg.getText();
		return errorPasswordMessege;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
