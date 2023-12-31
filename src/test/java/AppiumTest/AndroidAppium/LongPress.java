package AppiumTest.AndroidAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LongPress extends BaseTest{
	
	@Test
	public void longPress()
	
	
	{
		
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
	driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	
	WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	longPressAction(ele);
	String expTitle = driver.findElement(By.id("android:id/title")).getText();
	Assert.assertEquals(expTitle, "Sample menu");
	
		
	
	}



}
