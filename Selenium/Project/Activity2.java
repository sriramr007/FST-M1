package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
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
	public void activity2() {
		
		WebElement companyLogo = driver.findElement(By.xpath("//div[@class='companylogo']//img"));
		String imageUrl = companyLogo.getAttribute("src");
		System.out.println("URL of the Header Image : " + imageUrl);
		Reporter.log("URL of the Header Image : " + imageUrl);
		
	}
	
	@AfterClass
    public void tearDown() {
        Reporter.log("Ending Test...");
        driver.close();
    }
	
}
