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

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AndroidBillPaymentTest extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		//dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		//dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		dc.setCapability("testName", "AndroidBillPaymentTest");
		dc.setCapability(MobileCapabilityType.UDID, "4200d659f296c45f");
//        dc.setCapability(MobileCapabilityType.APP, "cloud:com.ocbc.mobile.uat/com.ocbc.mib.activities.ActivitySplash");
//        dc.setCapability("appVersion", "11.5");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ocbc.mobile.uat");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ocbc.mib.activities.ActivitySplash");

		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
		 
	}
	
	@Test
	public void test(){
		// Enter the test code
		
//        driver.findElement(By.xpath("//*[@id='permission_allow_button']")).click();
//        driver.findElement(By.xpath("//*[@id='permission_allow_button']")).click();
//      try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Ok, got it']")).click();
        SeeTestClient seeTest = new SeeTestClient(driver);

		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='accessCodeInput']")));
        driver.findElement(By.xpath("//*[@id='accessCodeInput']")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.getKeyboard().sendKeys("0055826");
        driver.findElement(By.xpath("//*[@id='pinInput']")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.getKeyboard().sendKeys("123456");
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Login']")));
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Do it later']")));
//        driver.findElement(By.xpath("//*[@text='Do it later']")).click();
//        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Ok, got it!']")));
//        driver.findElement(By.xpath("//*[@text='Ok, got it!']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='appmenu-hamburger']")));
        driver.findElement(By.xpath("//*[@id='appmenu-hamburger']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Transfer']")));
        driver.findElement(By.xpath("//*[@text='Pay']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Bill payment']")));
        driver.findElement(By.xpath("//*[@text='Bill payment']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Credit card']")));
        driver.findElement(By.xpath("//*[@text='Credit card']")).click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tv_pin1']")));
        driver.findElement(By.xpath("//*[@id='tv_pin1']")).click();
        driver.getKeyboard().sendKeys("111111");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='submit_btn']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='currency']")));
        driver.findElement(By.xpath("//*[@id='currency']")).click();
        driver.getKeyboard().sendKeys("10000");
        driver.hideKeyboard();
//        driver.executeScript("seetest:client.drag(\"//*[@text='Slide toSubmit']\", 1000, 0)");
        seeTest.drag("NATIVE", "//*[@text='Slide toSubmit']", 0, 1000, 0);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Confirm payment']")));
        driver.findElement(By.xpath("//*[@text='Confirm payment']")).click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='appmenu-hamburger']")));
        driver.findElement(By.xpath("//*[@id='appmenu-hamburger']")).click();
        driver.findElement(By.xpath("//*[@id='appmenu-logout']")).click();

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
