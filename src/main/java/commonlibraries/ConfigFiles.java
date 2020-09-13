package commonlibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import commonBusinessScripts.HomePage;
import commonBusinessScripts.LoginPage;

public class ConfigFiles 
{
	
	public DriverScripts d = new DriverScripts();
	public static WebDriver driver = null;
	public FileData data = new FileData();
	
	@BeforeClass
	public void LaunchBrowser() throws Exception
	{
		String browser = data.fetchDataFromPropertiesFile("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}else if (browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		String url = data.fetchDataFromPropertiesFile("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void Login() throws Exception
	{
		String user = data.fetchDataFromPropertiesFile("username");
		String psw = data.fetchDataFromPropertiesFile("password");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.LoginToVtiger(user,psw);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Administrator - Home"));
	}
	
	@AfterMethod
	public void signOut()
	{
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.logOut();
	}
	
	
	@AfterClass
	public void tearout()
	{
		driver.quit();
	}
}
