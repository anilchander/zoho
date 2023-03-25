package zoho.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoSignInPO extends ZohoBasePO {
	private String email_xpath = "//input[@id='login_id']";
	private String nextbtn_xpath = "//button[@id='nextbtn']";
	private String nextbtn_trans_xpath = "//button[@id='nextbtn' and @disabled]";
	private String password_xpath = "//input[@id='password']";
	private String signInBtn_xpath = "//button[.='Sign in']";
	private String signInBtn_trans_xpath = "//button[.='Sign in' and @disabled]";

	public ZohoSignInPO(WebDriver driver) {
		super(driver);
	}

	public ZohoHomePO signInWithEmailAndPassword(String emailId, String password) throws Exception {
		this.getElement(email_xpath).sendKeys(emailId);
		this.getElement(nextbtn_xpath).click();

		try {
			this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextbtn_trans_xpath)));
			this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(nextbtn_trans_xpath)));
		} catch (Exception e) {

		}

		this.getElement(password_xpath).sendKeys(password);
		this.getElement(signInBtn_xpath).click();

		return new ZohoHomePO(driver);
	}

}
