package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	
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
	public void activity7(String username, String password) throws InterruptedException {
		
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
		
		WebElement salesMenu = driver.findElement(By.xpath("//a[starts-with(@id, 'grouptab') and contains(text(), 'Sales')]"));
		wait.until(ExpectedConditions.elementToBeClickable(salesMenu));
		
		Actions action = new Actions(driver);
		action.moveToElement(salesMenu).perform();
		
		WebElement leadsSubmenu = driver.findElement(By.xpath("//a[starts-with(@id, 'moduleTab') and contains(text(), 'Leads')]"));
		leadsSubmenu.click();
		
		WebElement loader = driver.findElement(By.xpath("//div[@id='loadingPage']//b[contains(text(), 'Loading page, please wait...')]"));
		wait.until(ExpectedConditions.invisibilityOf(loader));
		Thread.sleep(2000);
		
		WebElement additionalDetails = driver.findElement(By.xpath("//div[@class='list-view-rounded-corners']//tbody//tr[1]//td[10]//span[@class='suitepicon suitepicon-action-info']"));
		wait.until(ExpectedConditions.elementToBeClickable(additionalDetails));
		additionalDetails.click();
		Thread.sleep(2000);
		
		WebElement additionalDetailsPhone = driver.findElement(By.xpath("//span[@class='phone']"));
		String leadPhone = additionalDetailsPhone.getText();
		
		System.out.println("Lead Phone No : " + leadPhone);
		Reporter.log("Lead Phone No : " + leadPhone);
		
	}
	
	@AfterClass
    public void tearDown() {
        Reporter.log("Ending Test...");
        driver.close();
    }
	
}
