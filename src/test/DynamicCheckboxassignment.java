package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicCheckboxassignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
		//driver.findElement(By.xpath("//fieldset/label[@for='benz']/input")).click();
		Thread.sleep(3000L);
		String chekboxvalue = driver.findElement(By.xpath("//fieldset/label[@for='benz']")).getText();

		System.out.println(chekboxvalue);
		WebElement dropdown= driver.findElement(By.xpath("//fieldset/select[@id='dropdown-class-example']"));
		Select value = new Select(dropdown);
		value.selectByVisibleText(chekboxvalue);
		driver.findElement(By.name("enter-name")).sendKeys(chekboxvalue);
		driver.findElement(By.xpath("//input[@type= 'submit']")).click();
		System.out.println(driver.switchTo().alert().getText());
		String alertText= driver.switchTo().alert().getText();
		System.out.println(alertText);
		Assert.assertTrue(alertText.contains(chekboxvalue));
		driver.switchTo().alert().accept();
		
		

	}

	

}
