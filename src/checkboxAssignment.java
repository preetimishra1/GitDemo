import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class checkboxAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Assert.assertFalse(driver.findElement(By.cssSelector("input#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("input#checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input#checkBoxOption1")).isSelected());
	
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),3);
	}

}
