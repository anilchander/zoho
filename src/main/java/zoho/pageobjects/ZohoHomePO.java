package zoho.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoHomePO extends ZohoBasePO {
	private String profileImg_xpath = "//img[@id='ztb-profile-image-pre']";
	private String signOutbtn_xpath = "//a[@id='ztb-signout']";
	
	public ZohoHomePO(WebDriver driver) {
		super(driver);
	}
	
	public void signOut() throws Exception {
		this.getElement(profileImg_xpath).click();
		this.getElement(signOutbtn_xpath).click();
		
	}
	
	
	
	
	
}



