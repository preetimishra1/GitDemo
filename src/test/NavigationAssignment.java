package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class NavigationAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		driver.findElement(By.cssSelector("img.banner-image")).click();
		Set<String> s1  = driver.getWindowHandles();
		Iterator<String> it = s1.iterator();
		String parenId = it.next();//0,1,2 index in set object
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.cssSelector("a.btn")).click();
		driver.findElement(By.id("first-name")).sendKeys("Preeti");
		driver.findElement(By.id("last-name")).sendKeys("Mishra");
		driver.findElement(By.id("email")).sendKeys("test@test.com");
		driver.findElement(By.id("mobile")).sendKeys("1234567890");
		WebElement staticDropdown = driver.findElement(By.id("country"));
		Select dropdown = new Select (staticDropdown);
		dropdown.selectByIndex(3);
		driver.findElement(By.id("city")).sendKeys("Lucknow");
		driver.findElement(By.id("message")).sendKeys("Welcome to registration");
		driver.findElement(By.id("code")).sendKeys("8n9o");
		driver.findElement(By.cssSelector("button.btn-primary")).click();

}
}
