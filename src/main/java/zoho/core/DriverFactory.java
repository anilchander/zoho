package zoho.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.beust.jcommander.Parameters;

import zoho.logging.ZohoLogger;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
	
	private static WebDriver setDriver(String browserType) throws Exception {
		WebDriver driver = null;
		switch (browserType.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\MyPrograms\\webdrivers\\chromedriver.exe");
			ChromeOptions chrome_options = new ChromeOptions(); // this is only for cross domain operations. chrome
																// ver 111
			chrome_options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chrome_options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\MyPrograms\\webdrivers\\geckodriver.exe");
			FirefoxOptions firefox_options = new FirefoxOptions();
			firefox_options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver(firefox_options);
			break;
		default:
			throw new Exception("BROWSER_NOT_IMPLEMENTED");

		}
		//driver.manage().window().maximize();
		return driver;
		
	}

	public static WebDriver getDriver(String browserType) throws Exception {
		if(driverPool.get()==null) {
			driverPool.set(setDriver(browserType));
		}
		return driverPool.get();
	}
	
	public static void cleanupDriver() {
		driverPool.get().quit();
		driverPool.remove();
	}

}
