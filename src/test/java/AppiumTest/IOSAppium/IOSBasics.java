package AppiumTest.IOSAppium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{
	
	@Test
	public void basics()
	{
		
		//locators - id, accesabilityID, classname, xpath, iosclasschain, iospredicateString
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name=='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
		String msg =driver.findElement(AppiumBy.iOSNsPredicateString("label BEGINSWITH[c] 'A message'")).getText();
		Assert.assertEquals(msg, "A message should be a short, complete sentence.");
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();
		
	}

}
