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
import com.experitest.client.Client;
import com.experitest.client.GridClient;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AndroidPDFLocal extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
    private String host = "localhost";
    private int port = 8889;
    private String accessKey = "eyJ4cC51Ijo0NTEsInhwLnAiOjEsInhwLm0iOiJNVFUzT1RFMU5qWTBNREV4TlEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4OTQ1MTY2NDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.0Q5aRmOWOgo8g_XHNhLEnACjkTVmOrX7x4NaUvRdFiA";
    private String projectBaseDirectory = "C:\\Users\\sazal.sharan\\workspace\\project2";
    protected Client client = null;
    protected GridClient grid = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android' and @serialnumber='ce051715a875d53301'") String deviceQuery) throws Exception{
		init(deviceQuery);
        grid = new GridClient(accessKey, "ocbc.experitest.com",443, true);
        client = grid.lockDeviceForExecution("DigicertAndroid","{Device Query}", 10, 50000);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "DigicertAndroid");



	}
	
	@Test
	public void test(){
		// Enter the test code


	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
