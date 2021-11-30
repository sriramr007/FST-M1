package project;
//Goal: Use the Google Keep app to add a note.
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Test
public class Activity2 {

	WebDriverWait wait;
	String title ="New Note";
    AppiumDriver<MobileElement> driver = null;
    @BeforeTest
    public void setup() throws MalformedURLException {

    	// Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ClassMobile");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
        
    public void addNote() {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();
    	driver.findElement(By.id("com.google.android.keep:id/editable_title")).sendKeys(title);
    	driver.findElement(By.id("com.google.android.keep:id/edit_note_text")).sendKeys("Small description");
    	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();;
    	
    	String savedNoteTitle = driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
    	Assert.assertEquals(savedNoteTitle, title);
    	System.out.println("Newly added note is added successfully");
    }	
    
   @AfterTest
    public void tearDown() {
    	driver.quit();
   }
}
