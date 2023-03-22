package zoho.core;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;

import com.beust.jcommander.Parameters;

import zoho.logging.ZohoLogger;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>(); //to store the thread wise driver instances.
	
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
		case "docker-chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\MyPrograms\\webdrivers\\chromedriver.exe");
			DesiredCapabilities chrome_caps = new DesiredCapabilities();
			chrome_caps.setBrowserName(Browser.CHROME.browserName());
			ChromeOptions chrome_remote_options = new ChromeOptions(); // this is only for cross domain operations. chrome
																// ver 111
			chrome_remote_options.addArguments("--remote-allow-origins=*");
			chrome_caps.setCapability(ChromeOptions.CAPABILITY, chrome_remote_options);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chrome_caps);
			break;
		case "docker-firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\MyPrograms\\webdrivers\\geckodriver.exe");
			FirefoxOptions firefox_remote_options = new FirefoxOptions();
			firefox_remote_options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			DesiredCapabilities firefox_caps = new DesiredCapabilities();
			firefox_caps.setBrowserName(Browser.FIREFOX.browserName());
			driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefox_caps);
			break;
		default:
			throw new Exception("BROWSER_NOT_IMPLEMENTED");
		}
		//driver.manage().window().maximize();
		return driver;
		
	}

	public synchronized static WebDriver getDriver(String browserType) throws Exception {
		if(driverPool.get()==null) {
			driverPool.set(ThreadGuard.protect(setDriver(browserType)));
		}
		return driverPool.get();
	}
	
	public synchronized static void cleanupDriver() {
		driverPool.get().quit();
		driverPool.remove();
	}

}
