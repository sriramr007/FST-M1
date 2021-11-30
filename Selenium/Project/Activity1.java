package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity1 {
	
	WebDriver driver;
	@BeforeClass
    public void setUp() {
        //Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
 
        Reporter.log("Starting Test...");
        
        driver.get("https://alchemy.hguy.co/crm");
        Reporter.log("Opened Browser...");
        Reporter.log("Page title is " + driver.getTitle());
    }
	
	@Test
	public void activity1() {
		
		String pageTitle = driver.getTitle();
		
		Assert.assertEquals("SuiteCRM does not matches with website Title", "SuiteCRM", pageTitle);
		Reporter.log("Title of the website matches 'SuiteCRM' exactly");
		
	}
	
	@AfterClass
    public void tearDown() {
        Reporter.log("Ending Test...");
        driver.close();
    }
	
}
