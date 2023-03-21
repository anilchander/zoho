package zoho.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ZohoBasePO {
	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	public ZohoBasePO(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	public WebElement getElement(String xpath) {
		WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element = this.wait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) this.driver).executeScript("arguments[0].setAttribute('style','border:2px dashed red')", element);
		return element;
		
	}

}
