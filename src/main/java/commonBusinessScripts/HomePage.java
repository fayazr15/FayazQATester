package commonBusinessScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonlibraries.ConfigFiles;

public class HomePage extends ConfigFiles 
{
	@FindBy(xpath = "//td[@class='small']//td[2]//img[1]")
	private WebElement Administrator;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	
	public void logOut()
	{
		Administrator.click();
		signOut.click();
	}
	
}
