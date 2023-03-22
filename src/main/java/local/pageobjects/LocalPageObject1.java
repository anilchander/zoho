package local.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import zoho.pageobjects.ZohoBasePO;

public class LocalPageObject1 extends ZohoBasePO {
	private String notificationExamples = "Notification Examples";

	public LocalPageObject1(WebDriver driver) {
		super(driver);
	}
	
	public NotificationsPO navigate() throws Exception {
		this.driver.get("https://web-push-book.gauntface.com/demos/");
		this.driver.findElement(By.linkText(notificationExamples )).click();
		Thread.sleep(3000);
		return new NotificationsPO(this.driver);
	}

}
