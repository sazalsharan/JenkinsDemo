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

public class IosPDFReader extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		//dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "iOSPDFViewer");
//		 dc.setCapability("instrumentApp", true);
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

		driver.findElement(By.xpath("//*[@text='Access code']")).click();
		driver.getKeyboard().sendKeys("49019572");
//		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@text='OCBC - MIB']/*[@class='UIAView'])[4]/*[@class='UIATextField'])[2]")));
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
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Submit']")));
		driver.findElement(By.xpath("//*[@text='otp1']")).click();
		driver.getKeyboard().sendKeys("111111");
		driver.findElement(By.xpath("//*[@text='Submit']")).click();
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
        driver.findElement(By.xpath("//*[@value='e-Statements']")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='View e-Statements']")));
		driver.findElement(By.xpath("//*[@value='View e-Statements']")).click();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("//*[@text='November']")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("//*[@text='November' and @class='UIAStaticText' and ./parent::*[@text='November']]")).click();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("//*[@text='Consolidated Statement-Nov-19']")).click();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("//*[@text='OK']")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
