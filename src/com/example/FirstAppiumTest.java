package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstAppiumTest {
	
  AppiumDriver<WebElement> driver;
  
  @BeforeClass
  public void Setup() throws MalformedURLException {
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_28");
	  cap.setCapability(MobileCapabilityType.APP, "C:/Users/Marc Esso/Downloads/selendroid-test-app-0.17.0.apk");
	  cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability("avd", "Nexus_5X_API_28");
	  
	  driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
  }
  
  @BeforeMethod
  public void BeforeMethod () {
	  Assert.assertNotNull(driver.getContext());
  }
  
  @Test
  public void ButtonTest() throws InterruptedException {  
	  
	  // Click on the OK Button when the application is loaded on new android versions
      WebElement w = driver.findElement(By.id("android:id/button1"));
	  w.click();
  }
  
  @Test
  public void ENButtonTest() throws InterruptedException {

	  // Click on the EN Button
	  TimeUnit.SECONDS.sleep(2);
	  WebElement w = driver.findElement(By.id("io.selendroid.testapp:id/buttonTest"));
      w.click();
      
      TimeUnit.SECONDS.sleep(2);
      w = driver.findElement(By.id("android:id/button2"));
      w.click();
      
      w = driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
	  
  }
  
  @Test
	public void DisplayTextViewTest() throws InterruptedException {
		WebElement w;
		  
		// Write some text in the textfield
		TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/visibleTextView"));
	    w.equals("Text is sometimes displayed");
		  
	}

	@Test
	public void TextFieldTest() throws InterruptedException {
		WebElement w;
		  
		// Write some text in the textfield
		TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/my_text_field"));
	    w.sendKeys("Testing TextField");
		  
	}
	
	@Test
	public void UserRegistrationTest() throws InterruptedException {
		  WebElement w;	  
		  
		  // Click on the Registration Button
		TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
	    w.sendKeys("username");
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
	    w.sendKeys("email@email.com");
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
	    w.sendKeys("password");
	    
	    driver.navigate().back();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage"));
	    w.click();
		  
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[4]"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser"));
	    w.click();
	    TimeUnit.SECONDS.sleep(2);
	}
	
	@Test
	public void WebViewTest() throws InterruptedException {
		WebElement w;	  
		  
		  // Click on the Registration Button
		TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/spinner_webdriver_test_data"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[4]"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/goBack"));
	    w.click();
	    
	}
 
  @AfterClass
  public void CloseApp(){
  	//close the application
//  	driver.quit();
  }
}
