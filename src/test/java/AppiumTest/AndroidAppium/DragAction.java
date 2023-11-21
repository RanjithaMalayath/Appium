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

public class DragAction extends BaseTest{
	
	@Test
	public void dragAndDrop() throws InterruptedException
	
	
	{
		
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
dragAndDrop(src);
Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");

Thread.sleep(2000);
	}
	
	



}
