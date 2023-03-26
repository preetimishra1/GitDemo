
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ekart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
				
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] veggiesNeeded = { "Cucumber", "Mango", "Grapes" };
		Thread.sleep(3000);
		addItems(driver, veggiesNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("button.promoInfo")).getText());
	}

	private static void addItems(WebDriver driver, String[] veggiesNeeded) {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();
			// format it to get actual vegetable name

			// check whether name you extracted is present in array or not?
			// convert Array to ArrayList easy search
			// Arraylist takes more memory than Array, so its should be craeted on run time
			List itemsNeededList = Arrays.asList(veggiesNeeded);

			if (itemsNeededList.contains(formattedname)) {
				// (j==itemsNeededList.;
				// click to add cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// 3 times
				if (j == 3) {
					break;
				}
			}
		}
	}
}
