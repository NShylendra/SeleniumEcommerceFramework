package Framework.ecommerce;

	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import junit.framework.Assert;

	public class completeCode {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			String name = "ADIDAS ORIGINAL";
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/client");
			
			driver.findElement(By.id("userEmail")).sendKeys("nshylendra@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Pass1234");
			driver.findElement(By.id("login")).click();
			
			List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-body b")));
			WebElement prod = products.stream().filter(product->
			product.findElement(By.cssSelector(".card-body b")).getText().equals(name)).findFirst().orElse(null);
			
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
			
			List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		    Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(name));

		    Assert.assertTrue(match);

			
			driver.findElement(By.cssSelector("div[class='subtotal cf ng-star-inserted'] button")).click();
			
			Actions ac = new Actions(driver);
			ac.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();
			driver.findElement(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:last-of-type")).click();
			
		    js.executeScript("window.scrollBy(0,700)");
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
			
			String result = driver.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertEquals("THANKYOU FOR THE ORDER.", result);
			driver.close();
			
		
			
			
			
			


		}

	}


