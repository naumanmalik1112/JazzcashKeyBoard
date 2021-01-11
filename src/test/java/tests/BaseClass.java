package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class BaseClass extends ExtentReportsDemo {

	AndroidDriver<AndroidElement> driver;

	@Parameters({"platform", "udid", "systemPort","device"})
	@BeforeTest(alwaysRun = true)
	
	public void setup(String platform, String udid, String systemPort,String device)  throws MalformedURLException{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", platform);
		desiredCapabilities.setCapability("deviceName",device);

		desiredCapabilities.setCapability("udid", udid);
		//desiredCapabilities.setCapability("autoGrantPermissions",true);
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
		//desiredCapabilities.setCapability("newCommandTimeout","30");
		desiredCapabilities.setCapability("appPackage", "com.techlogix.mobilinkcustomer");
		desiredCapabilities.setCapability("appActivity", "com.ibm.jazzcashconsumer.view.splash.SplashActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<AndroidElement>(url,desiredCapabilities);

	}
	
	
	
	@BeforeTest
	public void startReport() {
		extent.setSystemInfo("Operating System", "Android 10");
        extent.setSystemInfo("Application Name", "JazzCash Keyboard");
        extent.setSystemInfo("Device Name", "Samsung Galaxy A21s");
        extent.setSystemInfo("Environment", "JazzCash Staging Environment");
        extent.setSystemInfo("User Name", "Nauman Aziz Malik");
        
        html.config().setDocumentTitle("JazzCash Keyboard Automation");
        html.config().setReportName("JazzCash Keyboard Test Report");
        html.config().setTheme(Theme.DARK);
        
	}
}

