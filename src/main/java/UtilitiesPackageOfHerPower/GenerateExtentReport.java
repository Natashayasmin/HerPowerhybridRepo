package UtilitiesPackageOfHerPower;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport {

	public static ExtentReports generateExtentReportMethod() {
		ExtentReports extentReport = new ExtentReports(); 
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport1\\extentReport_v2.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Her Power");
		sparkReporter.config().setDocumentTitle("QA Report of Her Power");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm a");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties PropForReport = new Properties();
		File fileForReport = new File(System.getProperty("user.dir")+"\\BaseInfoConfig");
		
		try {
			FileInputStream fisforReport = new FileInputStream(fileForReport);
			PropForReport.load(fisforReport);
			} catch(Throwable e) {
				e.printStackTrace();
			}
		
		extentReport.setSystemInfo("Application URl", PropForReport.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", PropForReport.getProperty("browserName"));
		extentReport.setSystemInfo("Email", PropForReport.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", PropForReport.getProperty("validPassword"));
	
		extentReport.setSystemInfo("operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		
		return extentReport;
	}

}