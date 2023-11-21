package AppiumTest.IOSAppium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSLongPress extends IOSBaseTest {

	@Test
	public void longPress()
	{
		
		//locators - id, accesabilityID, classname, xpath, iosclasschain, iospredicateString
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		WebElement ele =driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		
		Map<String,Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		driver.executeScript("mobile: touchAndHold", params);
	
	}

}