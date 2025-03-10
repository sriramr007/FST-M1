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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	
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
	    public void addContact() {
	        // Click on add new contact floating button
	        driver.findElementByAccessibilityId("Create new contact").click();
	        
	        // Find the first name, last name, and phone number fields
	        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
	        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Surname']");
	        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
	        
	        // Enter the text in the fields
	        firstName.sendKeys("Aaditya");
	        lastName.sendKeys("Varma");
	        phoneNumber.sendKeys("9991284782");
	        
	        // Save the contact
	        driver.findElementById("editor_menu_save_button").click();
	        
	        // Wait for contact card to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
	 
	        // Assertion
	        MobileElement mobileCard = driver.findElementById("toolbar_parent");
	        Assert.assertTrue(mobileCard.isDisplayed());
	        
	        String contactName = driver.findElementById("large_title").getText();
	        Assert.assertEquals(contactName, "Aaditya Varma");
	    }
	 
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
