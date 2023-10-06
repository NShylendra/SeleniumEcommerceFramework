package Framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;


public class orderStatus extends AbstractComponent{
	
	
    WebDriver driver;
	
    public orderStatus(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
    
    @FindBy(css=".hero-primary")
    WebElement stringMsg;
    
    public String verifyOrder()
    {
    	String result = stringMsg.getText();
    	return result;
    }

}
