package AppiumTest.IOSAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();
		service.start();
		
		
		//2. Create object for UIAutomator2Options
		XCUITestOptions options = new XCUITestOptions();
		//3. Set Emulator device Name
		options.setDeviceName("iPhone 12 Pro");
		//4. Give path of the app(.apk) to install and open in the mobile/emulator
		options.setApp("//Users//ranjithamalayath//eclipse-workspace//AndroidAppium//src//test//java//Resources//UIKitCatalog.app");
		options.setPlatformVersion("17.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		//1.create driver object for AndroidDriver class and pass local host url with port no and object of options
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		
		
	}
	
	
	@AfterClass
	public void tearDown()
	{

		//7. close 
		driver.quit();
		//8.stop server
		service.stop();
		
	}
	

}
