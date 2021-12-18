package Test.Selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


@Test
public class AppiumCapabolities {

	AndroidDriver<MobileElement> driver;
	public void testAppium() throws MalformedURLException
	{
		
		DesiredCapabilities capabilities=  new DesiredCapabilities();
		capabilities.setCapability("deviceName", "V2033");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("platformName", "Android");
		File file =new File("D:\\Srikala\\Epam_RD_Automation-master\\XPATH_TASK\\apk\\UrbanYogi.apk");
		//(driver.setRequestHeader("accept-charset", "UTF-8");
		 //capabilities.setCapability("no",true);
	        capabilities.setCapability("newCommandTimeout", 100000);
	        capabilities.setCapability("noReset", true);
//	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//	        capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
			capabilities.setCapability("app", file.getAbsolutePath());
	 	    //capabilities.setCapability("automationName", "selendroid");
	        capabilities.setCapability("noReset", true);
 //	        capabilities.setCapability("appPackage", "com.capitalx.blissfully");
//	        capabilities.setCapability("appActivity", "ly.blissful.bliss.ui.ControllerActivity");
//	        capabilities.setCapability("waitForQuietness", false);
//	        capabilities.setCapability("waitForQuiescence", false);
//	        capabilities.setCapability("wdaEventloopIdleDelay", 7);
//	        capabilities.setCapability("eventLoopIdleDelaySec", 4);
//	        capabilities.setCapability("startIWDP", true);

		 driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		 MobileElement startJourney= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[3]"));
		 MobileElement letsDoIt= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[5]/android.view.View"));
		 MobileElement never= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[3]"));
		 MobileElement fewTimes = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[4]"));
		 MobileElement veryOften = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[5]"));
		 MobileElement age_20s = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[5]/android.view.View"));
		 MobileElement gender_female= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[11]"));
		 MobileElement continue_btn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View"));
		 MobileElement sleep_better= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[1]"));
		 MobileElement goNext= driver.findElement(By.xpath("//android.view.View[@content-desc=\"Go Next\"]"));
		 MobileElement firstName_txtBox= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.EditText[1]"));
		 MobileElement email_txtBox= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.EditText[2]"));
		 MobileElement pswd_txtBox= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.EditText[3]"));
		 MobileElement continue_btn2= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[2]"));
		 
		 
		 startJourney.click();
		 letsDoIt.click();
		 never.click();		 fewTimes.click(); fewTimes.click(); veryOften.click();
		 age_20s.click(); gender_female.click();
		 continue_btn.click(); 
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 sleep_better.click(); goNext.click();
		 firstName_txtBox.sendKeys("Monika"); email_txtBox.sendKeys("asdf@qwerty.com"); pswd_txtBox.sendKeys("password");
		 continue_btn2.click();
		 
			
	}
	@AfterMethod	    
	public void closeApp() {	           
		driver.quit();	     
		}
	

}
