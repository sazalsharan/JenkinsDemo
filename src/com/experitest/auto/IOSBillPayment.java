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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSBillPayment extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios' and @serialnumber='727fbe8b93954e100e0dcd0752da072ca580d8bc'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		//dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "iOSBillPayment	");
		dc.setCapability(MobileCapabilityType.UDID, "727fbe8b93954e100e0dcd0752da072ca580d8bc");
//		dc.setCapability(MobileCapabilityType.APP, "cloud:com.ocbc.uatmobile");
//		dc.setCapability("appVersion", "181");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.ocbc.uatmobile");

		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}

	@Test
	public void test() {
		// Enter the test code
		SeeTestClient seeTest = new SeeTestClient(driver);
//        driver.findElement(By.xpath("//*[@text='Allow']")).click();
//        driver.findElement(By.xpath("//*[@text='Only While Using the App']")).click();
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Next']")).click();
//        driver.findElement(By.xpath("//*[@text='Ok, got it']")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@text='Access code']")).click();
		driver.getKeyboard().sendKeys("0055826");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@text='OCBC - MIB']/*[@class='UIAView'])[4]/*[@class='UIATextField'])[2]")));
		driver.findElement(By.xpath("//*[@text='PIN']")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getKeyboard().sendKeys("123456");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Login']")));
		driver.findElement(By.xpath("//*[@text='Login']")).click();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAButton']")));
		driver.findElement(By.xpath("//*[@class='UIAButton']")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Pay']")));
		driver.findElement(By.xpath("//*[@text='Pay']")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Bill payment' and @class='UIAImage']")));
		driver.findElement(By.xpath("//*[@text='Bill payment' and @class='UIAImage']")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Credit card']")));
		driver.findElement(By.xpath("//*[@text='Credit card']")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Submit']")));
		driver.findElement(By.xpath("//*[@text='otp1']")).click();
		driver.getKeyboard().sendKeys("111111");
		driver.findElement(By.xpath("//*[@text='Submit']")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.context("WEBVIEW_1");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='currency']")));
		driver.findElement(By.xpath("//*[@id='currency']")).click();
		driver.getKeyboard().sendKeys("500000000");
		seeTest.drag("NATIVE", "//*[@text='Submit']", 0, 1000, 0);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        seeTest.click("NATIVE", "nixpath=//*[@value='Confirm payment']", 0, 1);
//		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Transaction history']")));
//		driver.findElement(By.xpath("//*[@text='Transaction history']")).click();
//		driver.context("NATIVE_APP");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
