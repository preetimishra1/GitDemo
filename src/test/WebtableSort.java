package test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebtableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//clickon column
		driver.findElement(By.xpath("//tr/th[1]"));
		//capture all webelements into list
		List<WebElement>  elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new list(original)
		List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort on the original list->sorted list
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		//campare two list'
		
		//Assert.assertTrue(originalList.equals(sortedList));
		
		//scan the name column and if we get text -> Beans -> print price of rice
		List<String> price ;
		do
		{
			List<WebElement>  rows = driver.findElements(By.xpath("//tr/td[1]"));
			
		price = rows.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceofVeggie(s)).collect(Collectors.toList());
	price.forEach(a->System.out.println(a));
	if(price.size()<1)
	{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	}
	
	}while(price.size()<1);
	}
	

	private static String getPriceofVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		// TODO Auto-generated method stub
		return pricevalue;
	}

}
