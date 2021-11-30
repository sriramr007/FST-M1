package Activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;
	 
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
   }
	 @Test
	    public void testSearchAppium() {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        driver.get("https://www.training-support.net/");
	 
	        String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	        System.out.println("Title on Homepage: " + pageTitle);
	 
	        MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
	        aboutButton.click();
	 
	        String newPageTitle = driver
	                .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")
	                .getText();
	 
	        System.out.println("Title on new page: " + newPageTitle);
	 
	        // Assertions
	        Assert.assertEquals(pageTitle, "Training Support");
	        Assert.assertEquals(newPageTitle, "About Us");
	    }
	 
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}
