package commonlibraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DriverScripts

{
 public void AssertTrue(String act,String exp)
 {
	 Assert.assertTrue(act.contains(exp));
 }
 
 public void selectClass(WebElement webelement,String expElement)
 {
	 Select s = new Select(webelement);
	 s.selectByValue(expElement);
 }
	
}
