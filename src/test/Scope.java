package test;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php/");
		
		//count of links on page
		//a -link should have tagname a anchor on html page
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		//By.xpath("//a");
		//get me count of links in footer section of page
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));//LIMITING WebDriver scope only for footer
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//3- links at first column==Discount Coupons===
		
		WebElement columndriver= footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//3- links at second  column==Latest News==
		
		WebElement columndriver2= footer.findElement(By.xpath("//table/tbody/tr/td[2]/ul"));
		System.out.println(columndriver2.findElements(By.tagName("a")).size());
		
		//4-click on each link and check if the pages are open
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String ClickonlinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonlinkTab);
			Thread.sleep(5000L);
		}//opens all tab
		
		
			//GET Title of each link page
			
			Set<String> linktitle= driver.getWindowHandles();
			Iterator<String>  lt= linktitle.iterator();
			
			while(lt.hasNext())
			{
				driver.switchTo().window(lt.next());
				System.out.println(driver.getTitle());
			}
		}
		
		
		
	}


