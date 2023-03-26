package test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium4enhance {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		//Relative locators
		
		WebElement nameEditBox = driver.findElement(By.name("name"));
		driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(nameEditBox);
		//driver.findElement(By.name("name")).sendKeys("Preeti Mishra");
		
		//open multiple window/tabs
		//driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
	Set<String> tabs = 	driver.getWindowHandles();
	 Iterator<String> it = tabs.iterator();
	String parentwindow =  it.next();
	String childwindow =  it.next();
	driver.switchTo().window(childwindow);
	driver.get("https://www.rahulshettyacademy.com");
	String titlename = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
	System.out.println(titlename);
	driver.switchTo().window(parentwindow);
	WebElement Name = driver.findElement(By.name("name"));
			Name.sendKeys(titlename);
	//capture webelement screenshot
			
			//Sel3- complete entire window screenshot
			//File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src,new File("C:\\Users\\ASUS\\screenshot.png"));
			
			//sel4--> take screenshot for particular webelement only
	File file = Name.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File ("screenshot.png"));
	
	//Get Dimension
	
	System.out.println(Name.getRect().getDimension().getHeight());
	System.out.println(Name.getRect().getDimension().getWidth());
	driver.quit();

	}

}
