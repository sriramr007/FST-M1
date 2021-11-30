package project;
//Goal: Opening a page on the browser and testing a simple login page with correct and incorrect credentials


import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Test
public class Activity5 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	String UserName = "admin";
	String PassWord = "password";
	String UserName1 = "admin1";
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
        
    public void LoginForm() {
    	// wait for page to load
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//Scroll to find the Login Form card and click it       
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(textStartsWith(\"Login Form\"))"));
  	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  	driver.findElement(MobileBy.xpath("//android.view.View[@content-desc=\"Login Form Please sign in.\"]")).click();
  	  	
  	  	//Once the page loads, login with username and password - correct credentials
  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys(UserName);
  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys(PassWord);
  	  	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();

  	  	String successMess=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
  	  	Assert.assertEquals(successMess, "Welcome Back, admin");
  	  	System.out.println("Login is success & case is passed");
  	  	
  	  	//Once the page loads, login with username and password - incorrect credentials
  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).clear();
  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).clear();
  	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys(UserName1);
	  	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys(PassWord);
  	  	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();

  	  	String failureMess=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
  	  	Assert.assertEquals(failureMess, "Invalid Credentials");
  	  	System.out.println("Login is Failed & case is failed");
  	  	}    	    	
    
   @AfterTest
    public void tearDown() {
    	driver.quit();
   }
}
