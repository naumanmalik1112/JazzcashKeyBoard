package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportsDemo {
	ExtentHtmlReporter html; 
	ExtentReports extent;
	
	@BeforeSuite
	public void reportSetup(){
		// path where output is to be printed
		html = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(html);

	}
	
	@AfterSuite
	public void reportTearDown(){
		extent.flush();
	}
}
