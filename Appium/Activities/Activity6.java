package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	
	AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	 
	 @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		 DesiredCapabilities Caps = new DesiredCapabilities();
		 Caps.setCapability("deviceName", "Pixel4_TestDevice");
		 Caps.setCapability("platformName", "android");
		 Caps.setCapability("automationName", "UiAutomator2");
		 Caps.setCapability("appPackage", "com.android.calculator2");
		 Caps.setCapability("appActivity", ".Calculator");
		 Caps.setCapability("noReset", true);
		 

     // Instantiate Appium Driver
		 URL RemotUrl = new URL("http://localhost:4723/wd/hub");
		 driver = new AndroidDriver<MobileElement>(RemotUrl,Caps);
		 wait = new WebDriverWait(driver, 5);
		 driver.get("https://www.training-support.net/selenium/lazy-loading");
 }
	 @Test
	    public void imageScrollTest() {
	        // wait for page to load
	        MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
	        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
	 
	        // Count the number of images shown on the screen
	        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	        System.out.println("Number of image shown currently: " + numberOfImages.size());
	        
	        // Assertion before scrolling
	        Assert.assertEquals(numberOfImages.size(), 4);
	        
	        // Scroll to Helen's post
	        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
	        
	        // Find the number of images shown after scrolling
	        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	        System.out.println("Number of image shown currently: " + numberOfImages.size());
	        
	        // Assertion after scrolling
	        Assert.assertEquals(numberOfImages.size(), 4);
	    }
	 
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	 
}
