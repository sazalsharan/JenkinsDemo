package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class ReporterDemo extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client = null;
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.ocbc.mobilebv/.app.login.LoginNewActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ocbc.mobilebv");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".app.login.LoginNewActivity");
		dc.setCapability("appVersion", "4.4");
		dc.setCapability("instrumentApp", true);
		dc.setCapability("testName", "AndroidDemoTest");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	@Test
	public void test() throws InterruptedException{
		
		client.setShowReport(false);
	
		if(driver.findElement(By.xpath("//*[@text='The internet connection appears to be offline.' and @id='callphone']")).isDisplayed()) {
			report("Error Message : 'The internet connection appears to be offline.", true);
			driver.findElement(By.xpath("//*[@text='OK' and @id='button1']")).click();
		}

		//////Login Flow starts//////////
		waitForElement("//*[@id='velocity_org_edt']");
		driver.findElement(By.xpath("//*[@id='velocity_org_edt']")).sendKeys("PERFORGU3005");
		report("Velocity id 'PERFORGU3005' entered.", false);

		driver.findElement(By.xpath("//*[@id='velocity_user_edt']")).sendKeys("PERFU3002");
		report("Username 'PERFU3002' entered.", true);

		driver.findElement(By.xpath("//*[@id='user_password_edt']")).sendKeys("123456");
		report("Password '123456' entered.", true);

		driver.findElement(By.xpath("//*[@text='Login']")).click();
		report("User clicked on 'Submit' button to login.", true);

		waitForElement("//*[@id='otpfd1']");
		driver.findElement(By.xpath("//*[@id='otpfd1']")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys("123456");
		a.perform();

		waitForElement("//*[@text='Submit' and @id='login_otp_submit' and @enabled='true']");
		driver.findElement(By.xpath("//*[@text='Submit' and @id='login_otp_submit' and @enabled='true']")).click();
		report("OTP '123456' entered", true);

		waitForElement("//*[@text='Logout']");
		report("User succefully logged in", true);

		/////Login Flow ends////////////////

		
	}
	
	public void waitForElement(String xpath) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		Thread.sleep(3000);
	}
	
	public void report(String step , Boolean status) throws InterruptedException {
		client.setShowReport(true);
		client.report(step, true);
		client.setShowReport(false);

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
