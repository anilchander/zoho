package local.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zoho.pageobjects.ZohoBasePO;

public class NotificationsPO extends ZohoBasePO {

	private final String toggleNotificationXpath = "//input";
	public NotificationsPO(WebDriver driver) {
		super(driver);
	}
	
	public void clickToggleNotification() throws Exception {
		((JavascriptExecutor)this.driver).executeScript("document.querySelector('.c-toggle.js-example-toggle').removeAttribute('disabled')");
		((JavascriptExecutor)this.driver).executeScript("document.querySelector('.c-toggle.js-example-toggle').click()");
		Thread.sleep(5000);
	}
	

}
