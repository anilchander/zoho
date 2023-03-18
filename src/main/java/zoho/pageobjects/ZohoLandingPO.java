package zoho.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoLandingPO {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	//private String SignIn = "//a[text()='Sign in']";
	@FindBy(xpath = "//a[text()='Sign in']" )
	WebElement SignIn;
	
	public ZohoLandingPO(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void navigate() {
		this.driver.get("https://www.zoho.com/");
	}
	
	
	public ZohoSignInPO zohoSignIn() throws Exception {
		this.wait.until(ExpectedConditions.elementToBeClickable(SignIn));
		SignIn.click();
		return new ZohoSignInPO(driver);
	}
	
	
	
}



