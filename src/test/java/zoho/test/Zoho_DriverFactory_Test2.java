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
import zoho.test.utils.BaseTest;
public class Zoho_DriverFactory_Test2 extends BaseTest {
//	@Test(dataProvider ="userdata",dataProviderClass = TestDataProvider.class)
//	public void mytest6(String username, String password) throws Exception {
//		ZohoLogger logger = new ZohoLogger(this);
//		ZohoLandingPO landingPage = new ZohoLandingPO(getDriver(this.getDriver()));
//		logger.logInfo("Navigating to the landing Page...");
//		landingPage.navigate();
//		logger.logInfo("Clicking on the signin link");
//		ZohoSignInPO signInPage = landingPage.zohoSignIn();
//		ZohoHomePO homePage = signInPage.signInWithEmailAndPassword(username, password);
//		homePage.signOut();
//		
//	}
	
	@Test()
	public void mytest7() throws Exception {
		ZohoLogger logger = new ZohoLogger(this);
		ZohoLandingPO landingPage = new ZohoLandingPO(this.getDriver());
		logger.logInfo("Navigating to the landing Page...");
		landingPage.navigate();
		logger.logInfo("Clicking on the signin link");
		ZohoSignInPO signInPage = landingPage.zohoSignIn();
		ZohoHomePO homePage = signInPage.signInWithEmailAndPassword("hpamitsinha@gmail.com", "Avyaan@2023");
		homePage.signOut();
	}
	
	@Test()
	public void mytest8() throws Exception {
		ZohoLogger logger = new ZohoLogger(this);
		ZohoLandingPO landingPage = new ZohoLandingPO(this.getDriver());
		logger.logInfo("Navigating to the landing Page...");
		landingPage.navigate();
		logger.logInfo("Clicking on the signin link");
		ZohoSignInPO signInPage = landingPage.zohoSignIn();
		ZohoHomePO homePage = signInPage.signInWithEmailAndPassword("invaliduser1@gmail.com", "Avyaan@2023");
		homePage.signOut();
	}
	
//	@Test
//	public void mytest9() throws Exception {
//		this.getDriver().get("https://www.google.com");
//		Thread.sleep(3000);
//		this.getDriver().findElement(By.name("q")).sendKeys("disney");
//		this.getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
//
//	}
////	
//
//	@Test
//	public void mytest10() throws Exception {
//		this.getDriver().get("https://www.google.com");
//		Thread.sleep(3000);
//		this.getDriver().findElement(By.name("q")).sendKeys("universal");
//		this.getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
//
//	}
}
