package zoho.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
	public ExtentReportUtil() {
		super();
	}
	
	public static ExtentReports getExtentReporter() {
		String reportPath = null;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		String dateString = format.format(date);
		reportPath = System.getProperty("user.dir")
				.concat(File.separator)
				.concat("reports")
				.concat(File.separator)
				.concat("extentReport_")
				.concat(dateString)
				.concat(".html");
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().enableOfflineMode(true);
		sparkReporter.config().setDocumentTitle("ZohoReport");
		extent.attachReporter(sparkReporter);
		
		return extent;
	}
	
	

}
