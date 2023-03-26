import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class formAssigntmnet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.name("name"));
		driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(nameEditBox);
		driver.findElement(By.name("name")).sendKeys("Preeti Mishra");
		driver.findElement(with(By.tagName("label")).below(nameEditBox)).getText();
		  driver.findElement(By.name("email")).sendKeys("priti.iet2@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		driver.findElement(By.cssSelector("input#exampleCheck1")).click();
		WebElement option = driver.findElement(By.cssSelector("select#exampleFormControlSelect1"));
		Select dropdown = new Select (option);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.cssSelector("input#inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("1984-10-02");
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		String successfulMsg = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		
		System.out.println(successfulMsg);
	
				
		
		

	}

}