package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstAppiumTest {
	
  AppiumDriver<WebElement> driver;
  
  @BeforeClass
  public void Setup() throws MalformedURLException {
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_28");
	  cap.setCapability(MobileCapabilityType.APP, "C:/Users/Marc Esso/Downloads/ApiDemos-debug.apk");
	  cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	  cap.setCapability("avd", "Nexus_5X_API_28");
	  
	  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
  }
  
  @Test
  public void simpleTest() {
	  Assert.assertNotNull(driver.getContext());
//	  Assert.assertEquals(driver.getTitle(), "API Demos", "Title Mismatch");
	  Assert.assertEquals(driver.isBrowser(), false);
	  driver.quit();
	  
  }
  
  
}
