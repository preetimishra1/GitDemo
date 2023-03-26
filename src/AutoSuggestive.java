import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List <WebElement> list = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : list) 
		{
			if(option.getText().equalsIgnoreCase("india"))
			{
			System.out.println(option.getText());
	         option.click();
				break;
				
			}
		}
		///CheckBox selection
		//driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
	
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//get info text on icon
		
		WebElement toolTipText = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_SeniorCitizenDiv']"));
	    System.out.println(toolTipText.getText());
		//count of checkboxes
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		
	}

}
