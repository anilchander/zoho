package zoho.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoSignInPO {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	private String email_xpath = "//input[@id='login_id']";
	private String nextbtn_xpath = "//button[@id='nextbtn']";
	private String nextbtn_trans_xpath = "//button[@id='nextbtn' and @disabled]";
	private String password_xpath = "//input[@id='password']";
	private String signInBtn_xpath = "//button[.='Sign in']";
	private String signInBtn_trans_xpath = "//button[.='Sign in' and @disabled]";
	
	public ZohoSignInPO(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	
	
	public ZohoHomePO signInWithEmailAndPassword(String emailId, String password) throws Exception {
		WebElement emailField = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(email_xpath)));
		this.wait.until(ExpectedConditions.elementToBeClickable(emailField));
		emailField.sendKeys(emailId);
		
		this.driver.findElement(By.xpath(nextbtn_xpath)).click();
		
		
		this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextbtn_trans_xpath)));
		this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(nextbtn_trans_xpath)));
		
		WebElement passwordField = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_xpath)));
		this.wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		passwordField.sendKeys(password);
		
		this.driver.findElement(By.xpath(signInBtn_xpath)).click();
		
		return new ZohoHomePO(driver);
	}
	
	
	
	
	
}



