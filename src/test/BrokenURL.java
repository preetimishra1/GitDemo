package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenURL {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sa = new SoftAssert();
		// Broken URL
		// STEP 1- yo get all urls tied up to the links using Selenium
		// if status code 400 is broken
		// soft Assert- will not stop script execution , even have exception

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			// String url =
			// driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) (new URL(url).openConnection());
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			sa.assertTrue(respCode > 400,
					"The link with text" + link.getText() + "is broken link with code" + respCode);

		}
		sa.assertAll();
	}

}
