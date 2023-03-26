import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SynchronizationWAITAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#okayBtn"))).click();
		WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select (staticDropdown);
		dropdown.selectByIndex(2);
		driver.findElement(By.cssSelector("input#terms"));
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer.btn-info"));
		for(int i=0;i<products.size()-1;i++)
		{
			products.get(i).click();
		}
	
	driver.findElement(By.partialLinkText("Checkout")).click();
	Assert.assertTrue(driver.findElement(By.partialLinkText("Checkout")).isSelected());
		
	}

}
