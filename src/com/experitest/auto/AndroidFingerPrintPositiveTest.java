package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
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


public class AndroidFingerPrintPositiveTest extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		//dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		//dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		dc.setCapability("testName", "AndroidFingerPrintPositiveTest");
		dc.setCapability(MobileCapabilityType.UDID, "ce051715a875d53301");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}
	
	@Test
	public void test(){
		// Enter the test code
        driver.executeScript("seetest:client.swipeWhileNotFound(\"Down\", 100, 2000, \"NATIVE\", \"//*[@text='Fingerprint Authentication']\", 0, 1000, 5, true)");
        driver.findElement(By.xpath("//*[@text='SYMMETRIC AUTHENTICATION']")).click();
        driver.findElement(By.xpath("//*[@text='START']")).click();
        SeeTestClient seeTest = new SeeTestClient(driver);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        seeTest.setAuthenticationReply("AUTHENTICATION_FAILED", 0);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("//*[@text='CANCEL']")).click();

		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
