import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		//sibling-parent->child traverse
		//header/div/button[1]/following-sibling::button[1]
driver.get("https://rahulshettyacademy.com/AutomationPractice/");
driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
//sibling-child to parent traverse
//header/div/button[1]/parent::div
//header/div/button[1]/parent::div/parent::div/button[2]

driver.findElement(By.xpath("//header/div/button[1]/arent::div/parent::div/button[2]")).getText();
	}

}
