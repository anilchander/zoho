package zoho.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoHomePO {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	private String profileImg_xpath = "//img[@id='ztb-profile-image-pre']";
	private String signOutbtn_xpath = "//a[@id='ztb-signout']";
	
	public ZohoHomePO(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	
	
	public void signOut() throws Exception {
		WebElement profileImg = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(profileImg_xpath)));
		this.wait.until(ExpectedConditions.elementToBeClickable(profileImg));
		profileImg.click();
		
		WebElement signOutBtn = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(signOutbtn_xpath)));
		this.wait.until(ExpectedConditions.elementToBeClickable(signOutBtn));
		signOutBtn.click();
		
	}
	
	
	
	
	
}



