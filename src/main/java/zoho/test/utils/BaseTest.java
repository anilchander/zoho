package zoho.test.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import zoho.core.DriverFactory;



public abstract class BaseTest {
	protected String browser = null;
	public void setBrowser(String browserType) {
		this.browser = browserType;
	}
	
	public WebDriver getDriver() throws Exception {
		return DriverFactory.getDriver(this.browser);
	}
	
	public void cleanupDriver() {
		DriverFactory.cleanupDriver();
	}
	
	@BeforeMethod
	@Parameters("browserType")
	public void init(String browserType) throws Exception {
			this.setBrowser(browserType);
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(5000);
		this.cleanupDriver();
	}

}
