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

public class IosQRCodeTest2 extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios' and @serialnumber='727fbe8b93954e100e0dcd0752da072ca580d8bc'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		//dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "OCBCIosQRCodeTest");
       // dc.setCapability("instrumentApp", true);

		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}

	@Test
	public void test() {
		// Enter the test code
        driver.executeScript("seetest:client.launch(\"cloud:com.ocbc.mobile.paosg\", \"false\",\"true\")");
        driver.findElement(By.xpath("//*[@placeholder='Access Code']")).sendKeys("0055854");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@placeholder='PIN']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@value='ctaNext']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='Submit']")));
        driver.getKeyboard().sendKeys("111111");
        driver.findElement(By.xpath("//*[@value='Submit']")).click();

        SeeTestClient seeTest = new SeeTestClient(driver);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //Sets Auth Reply as Success.
        seeTest.simulateCapture("C:\\Users\\sazal.sharan\\Desktop\\OCBCQR.png");

        //driver.executeScript("seetest: client.setAuthenticationReply(\"Success\", 0)");
        try {
			Thread.sleep(15000);
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
