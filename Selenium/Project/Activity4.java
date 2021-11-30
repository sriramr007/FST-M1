package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity4 {
	
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
	
	@DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "pa$$w0rd" }};
    }
	
	@Test (dataProvider = "Authentication")
	public void activity4(String username, String password) {
		
		WebElement usernameField = driver.findElement(By.id("user_name"));
		usernameField.sendKeys(username);
		
		WebElement passwordField = driver.findElement(By.id("username_password"));
		passwordField.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.id("bigbutton"));
		loginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement recentlyViewed = driver.findElement(By.xpath("//div[@id='recentlyViewedSidebar']//h2"));
		wait.until(ExpectedConditions.textToBePresentInElement(recentlyViewed, "Recently Viewed"));
		
		Assert.assertEquals("Homepage not opened", recentlyViewed.getText(), "Recently Viewed");
		Reporter.log("Homepage opened");
		
	}
	
	@AfterClass
    public void tearDown() {
        Reporter.log("Ending Test...");
        driver.close();
    }
	
}
