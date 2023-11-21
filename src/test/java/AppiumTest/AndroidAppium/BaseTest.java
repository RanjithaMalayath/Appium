package AppiumTest.AndroidAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
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
		UiAutomator2Options options = new UiAutomator2Options();
		//3. Set Emulator device Name
		options.setDeviceName("RanjithaAndroid");
		//4. Give path of the app(.apk) to install and open in the mobile/emulator
		options.setApp("//Users//ranjithamalayath//eclipse-workspace//AndroidAppium//src//test//java//Resources//ApiDemos-debug.apk");
		
		//1.create driver object for AndroidDriver class and pass local host url with port no and object of options
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",20000));
			
	}
	
	public void scrollToElement(String textName)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+textName+"\"));"));

	}
	public void scrollToBottom()
	{
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of("left",100,"top",100,"width",200,"height",200,
				"direction","down","percent",3.0));
				
			
		}while(canScrollMore); 
	}
	
	public void swipe(WebElement firstImage, String direction)
	
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)firstImage).getId(),
				"direction",direction,
				"percent",0.75));
	}
	public void dragAndDrop(WebElement src)
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement)src).getId(), 
				"endX", 833,
				"endY",742));
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
