package Activities;

import java.net.MalformedURLException;
import java.net.URL;

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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
	
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
  }
	 @Test
	    public void smsTest() {
	        // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")));
	        // Locate the button to write a new message and click it
	        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
	 
	        // Enter the number to send message to
	        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
	 
	        // Enter your own phone number
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBoxLocator)));
	        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9014842678");
	        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	        
	        // Wait for message box to load
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));
	 
	        // Type in a message
	        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");
	 
	        // Send the message
	        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();
	 
	        // Wait for message to show
	        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
	 
	        // Assertion
	        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
	        Assert.assertEquals(sentMessageText, "Hello from Appium");
	    }
	 
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
