package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandleAssignmnet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.findElement(By.id("tabButton")).click();
		String mainwindow = driver.getWindowHandle();
		Set<String> s1  = driver.getWindowHandles();
		Iterator<String> it = s1.iterator();
		String parenId = it.next();//0,1,2 index in set object
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("h1#sampleHeading")).getText());
		driver.switchTo().window(parenId);
		System.out.println(driver.findElement(By.cssSelector("div.main-header")).getText());
				
			}
			
				
		}


