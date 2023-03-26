package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows= driver.getWindowHandles(); //parentId,childId
		Iterator<String> it = windows.iterator();
		String parenId = it.next();//0,1,2 index in set object
		String childId = it.next();
				driver.switchTo().window(childId);
				System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
				driver.findElement(By.cssSelector(".im-para.red")).getText();
				String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
				driver.switchTo().window(parenId);
				driver.findElement(By.id("username")).sendKeys(emailId);
				
	}

}
