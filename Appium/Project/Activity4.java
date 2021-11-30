package project;
//Goal: Opening a page on the browser and testing a to-do list page

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Test
public class Activity4 {
	WebDriverWait wait;
	String[] toDos = {"Add tasks to list", "Get number of tasks", "Clear the list"};
    AppiumDriver<MobileElement> driver = null;
    @BeforeTest
    public void setup() throws MalformedURLException {

    	// Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ClassMobile");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);
		driver.get("https://www.training-support.net/selenium");
    }
        
    public void addToDoList() {
    	// wait for page to load
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//Scroll to find to-Do list        
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(textStartsWith(\"To-Do List\"))"));
  	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  	driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
  	  	
  	  	//Clear toDos before starting
  	  	driver.findElement(By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]")).click();
  	  
  	  	//Add ToDos
  	  	for (String s : toDos) {
  	  		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys(s);
  	  		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
  	  	}
  	  	//Clear todos
  	  	driver.findElement(By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[@text='Add tasks to list']")).click();
  	  	driver.findElement(By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[@text='Get number of tasks']")).click();
	  	driver.findElement(By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[@text='Clear the list']")).click();
  	  	driver.findElement(By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]")).click();
  	  
  	  	//Assertion
  	  	List<MobileElement> cleared_Tasks = driver.findElements(MobileBy.AndroidUIAutomator("resourceId(\"tasksList\")"));
  	  	Assert.assertEquals(cleared_Tasks.size(), 0);
  	  	System.out.println("To-Do list added, striked and cleared successfully");

    }    	    	
    
   @AfterTest
    public void tearDown() {
    	driver.quit();
   }
}
