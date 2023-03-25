package local.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import local.pageobjects.LocalPageObject1;
import local.pageobjects.NotificationsPO;
import zoho.test.utils.BaseTest;

public class LocalTest extends BaseTest {
  NotificationsPO notificationPage = null;
  
    @BeforeClass
    @Parameters("browserType")
    public void setup(String browserType) {
    	this.setBrowser(browserType);
    }
    @AfterClass
	public void cleanup() throws Exception {
		Thread.sleep(5000);
		this.cleanupDriver();
	}
  
    
	@BeforeMethod
	@Parameters("browserType")
	public void init(String browserType) throws Exception {
			
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		
	}
  
  @Test
  public void f1() throws Exception {
	  LocalPageObject1 page1 = new LocalPageObject1(getDriver());
	  notificationPage =page1.navigate();
	  
  }
  @Test
  public void f2() throws Exception {
	  notificationPage.clickToggleNotification();
	  
  }
}
