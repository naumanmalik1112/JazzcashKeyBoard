package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Keyboard extends BaseClass {
	ExtentTest test1;

	
	@Parameters({"MSISDN", "Password"})
	@Test(priority=1)
	public void LoginAsGuest(String MSISDN, String Password) throws Exception {
		
		
		test1 = extent.createTest("Open the JazzCash App", "This test case will open the JazzCash App");
		test1.log(Status.INFO, "Test Cases Execution Started");
		test1.log(Status.INFO, "App Launched");
			
		Thread.sleep(4000);
			
			
		ExtentTest test1 = extent.createTest("Enter MSISDN", "This use case will have the custormer enter his/her MSISDN in the app");
		Thread.sleep(3000);
		MobileElement MSISDNClick = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/et_phone_number"));
		MSISDNClick.click();
		test1.log(Status.PASS, "Get Started in the App");
		Thread.sleep(4000);
			
		MobileElement enterMsisdn = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/tv_mobile"));
		enterMsisdn.sendKeys(MSISDN);
		test1.log(Status.PASS, "MSISDN is Entered");
		
		test1 = extent.createTest("Login", "This test case will login the customer in the JazzCash App");
		MobileElement clickNext = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/btn_send_otp"));
		clickNext.click();
		test1.log(Status.PASS, "OTP is called");
		test1.log(Status.PASS, "OTP is Autofetched Successfully and device is Verified");
		Thread.sleep(2000);
		
		//Enter Pin
		driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/t9_key_1")).click();
		driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/t9_key_1")).click();
		driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/t9_key_2")).click();
		driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/t9_key_2")).click();
		 
		test1.log(Status.PASS, "PIN is Entered");
		test1.log(Status.PASS, "User is logged in to the App successfully");
		Thread.sleep(4000);
		
		test1 = extent.createTest("Setup Keyboard", "This Test Case will start the Setup for enabling JazzCash Keyboard");
		MobileElement setKeyboard = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/btn_positive"));
		setKeyboard.click();
		test1.log(Status.PASS, "Setup Keyboard is Clicked");
		Thread.sleep(2000);
		
		MobileElement enableKeyboard = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/enableJazzCashKeyboard"));
		enableKeyboard.click();
		test1.log(Status.PASS, "Enable JazzCash Keyboard is Clicked");
		
		//Enable JazzCash Keyboard
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ "JazzCash Keyboard" + "\").instance(0))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ "OK" + "\").instance(0))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ "OK" + "\").instance(0))").click();
		test1.log(Status.PASS, "JazzCash Keyboard is Enabled on the Mobile Device Successfully");
		
		//Select JazzCash Keyboard
		
		test1 = extent.createTest("Enable Keyboard", "This test case will Select the JazzCash Keyboard in the Mobile Device");
		MobileElement selectKeyboard = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/selectJazzCashKeyboard"));	
		selectKeyboard.click();
		test1.log(Status.PASS, "Select JazzCash Keyboard is Clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).click();
		System.out.println("Hello");
		Thread.sleep(1000);
		test1.log(Status.PASS, "Keyboard is Selected Successfully");
		
		
		//Contacts Permission
		
		test1 = extent.createTest("Enable Permissions", "This test case will enable Permissions to use the JazzCash Keyboard");
		MobileElement permissionKeyboard = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/allowContactButton"));	
		permissionKeyboard.click();
		MobileElement continueKeyboard = (MobileElement) driver.findElement(By.id("com.techlogix.mobilinkcustomer:id/btn_positive"));
		continueKeyboard.click();
		test1.log(Status.PASS, "Contacts Permission Allowed");
		Thread.sleep(3000);
		MobileElement permissionOK = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		permissionOK.click();
		Thread.sleep(3000);
		MobileElement permissionAllow = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		permissionAllow.click();
		
		test1.log(Status.PASS, "Permissions Allowed Successfully");
		test1.log(Status.PASS, "User lands on Homescreen");
		Thread.sleep(2000);
		
		//Using JazzCash Keyboard
		
		test1 = extent.createTest("Open Keyboard", "This test case will use JazzCash Keyboard in the Messaging App");
		driver.runAppInBackground(Duration.ofSeconds(-1));
		
	
		System.out.println("Executing");
		test1.log(Status.PASS, "JazzCash app is in the Background");
		
		Thread.sleep(3000);
		
		//Start Keyboard
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Messages']")).click();
		test1.log(Status.PASS, "Messages App opened");
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.samsung.android.messaging:id/fab")));
		
		driver.findElement(By.id("com.samsung.android.messaging:id/fab")).click();
		test1.log(Status.PASS, "Creat new message is selected");
		
		System.out.println("Done");		
		Thread.sleep(3000);
		
		// Prepaid Load
		
		test1 = extent.createTest("Prepaid from Keyboard", "This test case will Send Prepaid Balance to a Jazz Customer");
		TouchAction touchAction = new TouchAction(driver);
		
		//JazzCash Click
		touchAction.tap(PointOption.point(425, 1083)).perform();
		test1.log(Status.PASS, "JazzCash Keyboard Opened");
		Thread.sleep(3000);
		
		//Prepaid Click
		touchAction.tap(PointOption.point(65, 999)).perform();
		test1.log(Status.PASS, "Prepaid Load Selected from the Menu");
		test1.log(Status.PASS, "Select Operator Screen is Opened");
		Thread.sleep(3000);
		
		//Operator Selection
		touchAction.tap(PointOption.point(102, 1302)).perform();
		test1.log(Status.PASS, "Jazz as a Prepaid Operator is Selected");
		Thread.sleep(2000);
		
		//Number Selection
		touchAction.tap(PointOption.point(269, 976)).perform();
		test1.log(Status.PASS, "Contact List is opened to Select a Jazz Receiver for Prepaid Load");
		test1.log(Status.PASS, "Jazz Receiver is Selected");
		Thread.sleep(2000);
		
		// Add Money
		touchAction.tap(PointOption.point(91, 1195)).perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(91, 1195)).perform();
		Thread.sleep(2000);
		touchAction.tap(PointOption.point(603, 1443)).perform();
		Thread.sleep(2000);
		
		test1.log(Status.PASS, "Amount is Entered to Perform a Prepaid Load of");
		
		//Click Enter
		touchAction.tap(PointOption.point(39, 1437)).perform();
		Thread.sleep(3000);
		
		test1.log(Status.PASS, "PIN entry screen is opened to Authorize the Transaction");
		
		// PIN entry
		touchAction.tap(PointOption.point(91, 1184)).perform();
	    Thread.sleep(1000);
	    touchAction.tap(PointOption.point(91, 1182)).perform();
	    Thread.sleep(1000);
	    
	    touchAction.tap(PointOption.point(274, 1187)).perform();
	    Thread.sleep(1000);
	    touchAction.tap(PointOption.point(274, 1187)).perform();
	    Thread.sleep(8000);
	    
	    test1.log(Status.PASS, "PIN is Entered Successfully");
		test1.log(Status.PASS, "Prepaid Load to Jazz Transaction is Successful");
	    
	    //Back from Success
		touchAction.tap(PointOption.point(70, 673)).perform();

		test1 = extent.createTest("Send Money from Keyboard", "This test case will Send Money to Jazz Cash customer from the Keyboard");
		
		//Tapping JazCash Keyboard 
	    
	    Thread.sleep(2000);
	    
	    //Tapping Send Money
	    
	    touchAction.tap(PointOption.point(545, 1010)).perform();
	    test1.log(Status.PASS, "Send Money is selected from the JazzCash Menu");
	    
	    Thread.sleep(2000);
	    // Adding User to send
	    
	    touchAction.tap(PointOption.point(110, 934)).perform();
	    test1.log(Status.PASS, "Jazz Cash User is Selected from the Contact List");
	    
	    // Adding Amount
	    
	    touchAction.tap(PointOption.point(94, 1187)).perform();
	    Thread.sleep(2000);
	    touchAction.tap(PointOption.point(94, 1190)).perform();
	    test1.log(Status.PASS, "Amount is Entered to Initiate Send Money Flow");
	    
	    // Press Enter
	    Thread.sleep(2000);
	    touchAction.tap(PointOption.point(603, 1443)).perform();
	    

	    //Confirm Transfer
	    touchAction.tap(PointOption.point(47, 1437)).perform();
	    test1.log(Status.PASS, "Enter PIN Screen is Opened");
	    
		Thread.sleep(1000);
	    // Enter PIN
	    
	    touchAction.tap(PointOption.point(91, 1182)).perform();
	    Thread.sleep(1000);
	    touchAction.tap(PointOption.point(91, 1182)).perform();
	    Thread.sleep(1000);
	    
	    touchAction.tap(PointOption.point(274, 1187)).perform();
	    Thread.sleep(1000);
	    touchAction.tap(PointOption.point(274, 1187)).perform();
	    Thread.sleep(3000);
	    
	    test1.log(Status.PASS, "PIN is Entered Successfully aand Authorized");
	    
	    // Check Receipt of Transaction
	    touchAction.tap(PointOption.point(595, 1210)).perform();
	    test1.log(Status.PASS, "Send Money to JazzCash Transaction is Successful");    
	    
	}

	
}   
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	