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

public class Activity5 {
	
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
	public void activity5(String username, String password) {
		
		WebElement usernameField = driver.findElement(By.id("user_name"));
		usernameField.sendKeys(username);
		
		WebElement passwordField = driver.findElement(By.id("username_password"));
		passwordField.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.id("bigbutton"));
		loginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement recentlyViewed = driver.findElement(By.xpath("//div[@id='recentlyViewedSidebar']//h2"));
		wait.until(ExpectedConditions.textToBePresentInElement(recentlyViewed, "Recently Viewed"));
		Reporter.log("Homepage opened");
		Reporter.log("<br>");
		
		WebElement toolbar = driver.findElement(By.id("toolbar"));
		String toolbarColor = toolbar.getCssValue("color");
		
		System.out.println("Colour of Toolbar : " + toolbarColor);
		Reporter.log("Colour of Toolbar : " + toolbarColor);
		
	}
	
	@AfterClass
    public void tearDown() {
        Reporter.log("Ending Test...");
        driver.close();
    }
	
}
