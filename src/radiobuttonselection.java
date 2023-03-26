import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class radiobuttonselection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//driver.findElements(By.cssSelector("div#travelOptions"));
		
		//radiobutton selection
		//Handle calendar- Enable/disable
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[name*='ctl00$mainContent$rbtnl_Trip']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[name*='ctl00$mainContent$rbtnl_Trip']")).size(),3);
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	
}

}
