package zoho.test;

import org.openqa.selenium.By;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import zoho.logging.ZohoLogger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import zoho.pageobjects.ZohoHomePO;
import zoho.pageobjects.ZohoLandingPO;
import zoho.pageobjects.ZohoSignInPO;
import static zoho.core.DriverFactory.getDriver;
import static zoho.core.DriverFactory.cleanupDriver;;
public class Zoho_DriverFactory_Test2 {

	private String browser = "";
	public WebDriver driver = null;
	@BeforeMethod
	@Parameters("browserType")
	public void init(String browserType) throws Exception {
			browser =browserType;
			driver = getDriver(browserType);
	}
	
	
//	@Test(dataProvider ="userdata",dataProviderClass = TestDataProvider.class)
//	public void mytest2(String username, String password) throws Exception {
//		
//		ZohoLogger logger = new ZohoLogger(this);
//		ZohoLandingPO landingPage = new ZohoLandingPO(getDriver(browser));
//		logger.logInfo("Navigating to the landing Page...");
//		landingPage.navigate();
//		logger.logInfo("Clicking on the signin link");
//		ZohoSignInPO signInPage = landingPage.zohoSignIn();
//		ZohoHomePO homePage = signInPage.signInWithEmailAndPassword(username, password);
//		homePage.signOut();
//		
//	}
	
//	@Test()
//	public void mytest2() throws Exception {
//		driver = getDriver(browser);
//		ZohoLogger logger = new ZohoLogger(this);
//		ZohoLandingPO landingPage = new ZohoLandingPO(driver);
//		logger.logInfo("Navigating to the landing Page...");
//		landingPage.navigate();
//		logger.logInfo("Clicking on the signin link");
//		ZohoSignInPO signInPage = landingPage.zohoSignIn();
//		ZohoHomePO homePage = signInPage.signInWithEmailAndPassword("hpamitsinha@gmail.com", "Avyaan@2023");
//		homePage.signOut();
//		
//	}
//	
	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(5000);
		cleanupDriver();
	}
	
	@Parameters("browserType")
	@Test
	public void mytest21(String browserType) throws Exception {
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("disney");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//driver.quit();

	}
//	
	@Parameters("browserType")
	@Test
	public void mytest23(String browserType) throws Exception {
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("universal");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.quit();

	}
}
