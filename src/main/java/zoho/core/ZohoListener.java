package zoho.core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import zoho.test.utils.BaseTest;
import zoho.utils.ExtentReportUtil;

public class ZohoListener implements ITestListener {
	
	private static ThreadLocal<ExtentTest> testpool = new ThreadLocal<>();
	private  ExtentReports extent;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
			test  = extent.createTest(result.getMethod().getMethodName());
			testpool.set(test);
		testpool.get().log(Status.INFO,result.getMethod().getMethodName()+" started" );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testpool.get().log(Status.PASS,MarkupHelper.createLabel(result.getMethod().getMethodName()+" passed", ExtentColor.GREEN));
		testpool.remove();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testpool.get().log(Status.FAIL,MarkupHelper.createLabel(result.getMethod().getMethodName()+" failed", ExtentColor.RED));
		try {
//			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getMethod("getDriver").invoke(result.getInstance());
			String base64string = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			testpool.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64string).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testpool.remove();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		extent = ExtentReportUtil.getExtentReporter();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
