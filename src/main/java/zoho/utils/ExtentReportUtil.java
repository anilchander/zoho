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
		sparkReporter.config().setReportName("ZohoReport");
		sparkReporter.config().setTimelineEnabled(true);
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("os", System.getProperty("os.name"));
		extent.setSystemInfo("Processors", String.valueOf(Runtime.getRuntime().availableProcessors()));
		extent.setSystemInfo("JVM Max Memory", String.valueOf(Runtime.getRuntime().maxMemory()));
		extent.setSystemInfo("JVM Free Memory", String.valueOf(Runtime.getRuntime().freeMemory()));
		extent.setSystemInfo("Java Version", System.getProperty("java.runtime.version"));
		
		return extent;
	}
	
	

}
