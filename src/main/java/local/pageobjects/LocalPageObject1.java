package local.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import zoho.pageobjects.ZohoBasePO;

public class LocalPageObject1 extends ZohoBasePO {
	private String notificationExamples = "Notification Examples";

	public LocalPageObject1(WebDriver driver) {
		super(driver);
	}
	
	public NotificationsPO navigate() {
		this.driver.get("https://web-push-book.gauntface.com/demos/");
		this.driver.findElement(By.linkText(notificationExamples )).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new NotificationsPO(this.driver);
	}

}
