package commonBusinessScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonlibraries.ConfigFiles;

public class LoginPage extends ConfigFiles

{
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement lgnbutton;
	
	
	
	public void LoginToVtiger(String user,String psw) throws Exception
	{
		
		username.sendKeys(user);
		password.sendKeys(psw);
		lgnbutton.click();
	}
	
}
