package com.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.utilities.XlsReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest {
	
  AppiumDriver<WebElement> driver;
  List excelData;
  
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
	  
	  
	try {
		excelData = XlsReader.ReadExcelFile();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
      
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
		  
		  String excel = excelData.get(0).toString();
		  String[] splitExcelData = excel.split("\\s+");
		  
		  // Click on the Registration Button
		TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
	    w.sendKeys(splitExcelData[1]);
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
	    w.sendKeys(splitExcelData[2]);
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
	    w.sendKeys(splitExcelData[3]);
	    
	    driver.navigate().back();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage"));
	    w.click();
		  
	    TimeUnit.SECONDS.sleep(2);
	    System.out.println(splitExcelData[4]);
	    int index = 1;
	    switch (splitExcelData[4]) {
		    case "Ruby":
		    	index = 1;
		    	break;
		    case "Php":
		    	index = 2;
		    	break;
		    case "Scala":
		    	index = 3;
		    	break;
		    case "Python":
		    	index = 4;
		    	break;
		    case "Javascript":
		    	index = 5;
		    	break;
		    case "Java":
		    	index = 6;
		    	break;
		    case "C++":
		    	index = 7;
		    	break;
		    case "C#":
		    	index = 8;
		    	break;
		    default:
		    	index=1;
	    	
	    }
		w = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView["+ index +"]"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    w = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
	    w.click();
	    
	    TimeUnit.SECONDS.sleep(2);
	    if (splitExcelData[5] != null){
	    	w = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
		    w.click();
	    }
	    
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
  	driver.quit();
  }
}
