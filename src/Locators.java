import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver_win32/chromedriver.exe");
				//SeleniumManager off--->Selenium 4--optional 
				WebDriver driver =  new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				driver.findElement(By.id("inputUsername")).sendKeys("rahul");
				driver.findElement(By.name("inputPassword")).sendKeys("hello2");
		        driver.findElement(By.className("signInBtn")).click();
		        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		        driver.findElement(By.linkText("Forgot your password?")).click();
		        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		       // driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@gmail.com");
		        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@gmail.com");
		        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test2@gmail.com");
		        driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345678");
		        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//span/label")).click();
		        driver.findElement(By.cssSelector("button[type='submit']")).click();
		        
		        
		        
		        
		     
		        
}
}