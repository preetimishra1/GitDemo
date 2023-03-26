import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2EndFlow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List <WebElement> lists = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : lists) 
		{
			if(option.getText().equalsIgnoreCase("india"))
			{
			System.out.println(option.getText());
	         option.click();
				break;
				
			}
		}
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select (staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
	
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for(int i=1;i<5;i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
			
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		
		//Dynamic drop down -  opens on user actions
		Thread.sleep(2000);
			
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
				
		System.out.println(driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).getText());
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
	

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//get info text on icon
		
		WebElement toolTipText = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_SeniorCitizenDiv']"));
	    System.out.println(toolTipText.getText());
		//count of checkboxes
		
	    driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		
}
}

