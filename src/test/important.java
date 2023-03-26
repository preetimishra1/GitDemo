package test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.Point;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class important {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		
		//Confirm-->approach to storing an alert from confirm box
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
		
		//Click the link to activate the alert
		driver.findElement(By.linkText("See a sample confirm")).click();

		//Wait for the alert to be displayed---Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
		wait.until(ExpectedConditions.alertIsPresent());
		
		//FluentWait
		
		
		//FluentWait instance defines the maximum amount of time to wait for a condition, 
		//as well as the frequency with which to check the condition.
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait3 = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);


		//Store the alert in a variable
		Alert alert = driver.switchTo().alert();

		//Store the alert in a variable for reuse
		String text = alert.getText();

		//Press the Cancel button
		alert.dismiss();
		
		

		//Alerts -->WebDriver can get the text from the popup and accept or dismiss these alerts.
		
		//Click the link to activate the alert
		driver.findElement(By.linkText("See an example alert")).click();

		//Wait for the alert to be displayed and store it in a variable
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(7000));
		Alert alert1 = wait1.until(ExpectedConditions.alertIsPresent());

		//Store the alert text in a variable
		String text1 = alert1.getText();

		//Press the OK button
		alert1.accept();
		  
		
		//Prompts are similar to confirm boxes, except they also include a text input
		
		//Click the link to activate the alert
		driver.findElement(By.linkText("See a sample prompt")).click();

		//Wait for the alert to be displayed and store it in a variable
		Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());

		//Type your message
		alert2.sendKeys("Selenium");

		//Press the OK button
		alert2.accept();
		
		///Browser Navigation
		
		//Convenient
		driver.get("https://selenium.dev");

		//Longer way
		driver.navigate().to("https://selenium.dev");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.getTitle();
		driver.getCurrentUrl();
		
		//File Upload
		driver.findElement(By.id("file-upload")).sendKeys("selenium-snapshot.jpg");
		
		//Take screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       	FileUtils.copyFile(scrFile, new File("./image.png"));
		
		//close all associated windows and tabs
		driver.quit();
		
		//close current window
		driver.close();
		
		//Information about web elements
		
		//Is Displayed 
		
		// Navigate to the url
		driver.get("https://www.selenium.dev/selenium/web/inputs.html");

		// Get boolean value for is element display
		boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
		
		//Is Enabled
		
		//navigates to url
		  driver.get("https://www.google.com/");

		  //returns true if element is enabled else returns false
		  boolean value2 = driver.findElement(By.name("btnK")).isEnabled();
		  
		  //Is Selected
		  
		  //navigates to url
		  driver.get("https://the-internet.herokuapp.com/checkboxes");

		  //returns true if element is checked else returns false
		  boolean value1 = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();
		  
		  //get x-y position
		// Navigate to url
		  driver.get("https://www.example.com");

		  // Returns height, width, x and y coordinates referenced element
		  Rectangle res =  driver.findElement(By.cssSelector("h1")).getRect();

		  // Rectangle class provides getX,getY, getWidth, getHeight methods
		  System.out.println(res.getX());
		  
		  
		// Enter text "q" and perform keyboard action "Enter"
	      driver.findElement(By.name("q")).sendKeys("q" + Keys.ENTER);
	    
	      
	      //Clear
	      
	      WebElement searchInput = driver.findElement(By.name("q"));
	      searchInput.sendKeys("selenium");
	      // Clears the entered text
	      searchInput.clear();
	      
	      //Evaluating a subset of the DOM
	      //to locate an element with a unique attribute that is an ancestor of the desired element and not an ancestor of the undesired element, 
	      //then call find element on that object:
	      
	      WebElement fruits = driver.findElement(By.id("fruits"));
	      WebElement fruit = fruits.findElement(By.className("tomatoes"));
	      
	      //Get element
	     //Get a collection of elements but want to work with a specific element,
	      //which means you need to iterate over the collection and identify the one you want.
	      
	      List<WebElement> elements = driver.findElements(By.tagName("li"));

	      for (WebElement element : elements) {
	          System.out.println("Paragraph text:" + element.getText());
	      }
	      
	      //Find Elements From Element
	      
	   // Get element with tag name 'div'
          WebElement element = driver.findElement(By.tagName("div"));

          // Get all the elements available with tag name 'p'
          List<WebElement> ele = element.findElements(By.tagName("p"));
          for (WebElement e : ele) {
              System.out.println(e.getText());
          }
          
          //Get Active Element
          
          // Get attribute of current active element
          String attr = driver.switchTo().activeElement().getAttribute("title");
          System.out.println(attr);
          
          //Add Cookies
          
       // Adds the cookie into current browser context
          driver.manage().addCookie(new Cookie("key", "value"));
          
          //Get Named Cookie
          
          // Get cookie details with named cookie 'foo'
          Cookie cookie1 = driver.manage().getCookieNamed("foo");
          System.out.println(cookie1);
          
          //Get All Cookies
          
          // Get All available cookies
          Set<Cookie> cookies = driver.manage().getCookies();
          System.out.println(cookies);
          
          //Delete Cookie
          
          // delete a cookie with name 'test1'
          driver.manage().deleteCookieNamed("test1");
          
          /*
          Selenium Java bindings also provides a way to delete
          cookie by passing cookie object of current browsing context
          */
         driver.manage().deleteCookie(cookie1);
         
         // deletes all cookies
         driver.manage().deleteAllCookies();
         
         //Working with IFrames and frames-->FRames allow the insertion of a document from an entirely different domain
          
        //1-Using WebElement
       
         //Store the web element
         WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));

         //Switch to the frame
         driver.switchTo().frame(iframe);

         //Now we can click the button
         driver.findElement(By.tagName("button")).click();
         
         //2-Using a name or ID
         
       //Using the ID
         driver.switchTo().frame("buttonframe");

         //Or using the name instead
         driver.switchTo().frame("myframe");

         //Now we can click the button
         driver.findElement(By.tagName("button")).click();
           
         
         //3-Using an index
         
      // Switches to the second frame
         driver.switchTo().frame(1);
         
         //4-Leaving a frame
      // Return to the top level
         driver.switchTo().defaultContent();
         
         //Working with windows and tab
         
       //Store the ID of the original window
         String originalWindow = driver.getWindowHandle();

         //Check we don't have other windows open already
         assert driver.getWindowHandles().size() == 1;

         //Click the link which opens in a new window
         driver.findElement(By.linkText("new window")).click();

         //Wait for the new window or tab
        // wait.until(numberOfWindowsToBe(2));

      // Opens a new tab and switches to new tab
         driver.switchTo().newWindow(WindowType.TAB);

         // Opens a new window and switches to new window
         driver.switchTo().newWindow(WindowType.WINDOW);
           
       //Close the tab or window
         driver.close();

         //Switch back to the old tab or window
         driver.switchTo().window(originalWindow);
         
         
         //Get window size
         
       //Access each dimension individually
         int width = driver.manage().window().getSize().getWidth();
         int height = driver.manage().window().getSize().getHeight();

         //Or store the dimensions and query them later
         Dimension size = driver.manage().window().getSize();
         int width1 = size.getWidth();
         int height1 = size.getHeight();
         //Wait for the new tab to finish loading content
         //wait.until(titleIs("Selenium documentation"));
         
         //Set window size==>Restores the window and sets the window size.
         
         driver.manage().window().setSize(new Dimension(1024, 768));
         
         //Get window position-->Fetches the coordinates of the top left coordinate of the browser window.

         // Access each dimension individually
         int x = driver.manage().window().getPosition().getX();
         int y = driver.manage().window().getPosition().getY();

         // Or store the dimensions and query them later
         Point position = driver.manage().window().getPosition();
         int x1 = position.getX();
         int y1 = position.getY();
         
      // Move the window to the top left of the primary monitor
         driver.manage().window().setPosition(new Point(0, 0));
         
         driver.manage().window().maximize();
         driver.manage().window().minimize();
         driver.manage().window().fullscreen();
         
         //Execute Script-->Executes JavaScript code snippet in the current context of a selected frame or window.
         
         //Creating the JavascriptExecutor interface object by Type casting
         JavascriptExecutor js = (JavascriptExecutor)driver;
       //Button Element
         WebElement button =driver.findElement(By.name("btnLogin"));
       //Executing JavaScript to click on element
         js.executeScript("arguments[0].click();", button);
       //Get return value from script
         String textt = (String) js.executeScript("return arguments[0].innerText", button);
       //Executing JavaScript directly
         js.executeScript("console.log('hello world')");
         
         //Print Page-->Prints the current page within the browser.
         driver.get("https://www.selenium.dev");
         printer = (PrintsPage) driver;

         PrintOptions printOptions = new PrintOptions();
         printOptions.setPageRanges("1-2");

         Pdf pdf = printer.print(printOptions);
         String content = pdf.getContent();
           
	}

}
