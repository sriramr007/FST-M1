package Activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Activity1 {
	AndroidDriver<MobileElement> driver;
	
	
	 @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		 DesiredCapabilities Caps = new DesiredCapabilities();
		 Caps.setCapability("deviceName", "Pixel4_TestDevice");
		 Caps.setCapability("platformName", "android");
		 Caps.setCapability("automationName", "UiAutomator2");
		 Caps.setCapability("appPackage", "com.android.calculator2");
		 Caps.setCapability("appActivity", ".Calculator");
		 Caps.setCapability("noReset", true);
		 
		 //Set Appium URL
		 URL RemotUrl = new URL("http://localhost:4723/wd/hub");
		 driver = new AndroidDriver<MobileElement>(RemotUrl,Caps);
	  }

  @Test
  public void f() {
  }
 
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
