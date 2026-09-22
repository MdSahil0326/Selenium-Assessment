package baseClassUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomUtilities.OrangeHrmLoginpage;

public class BaseClassOrangeHrm {
    protected WebDriver driver;
	@BeforeSuite
	public void bs()
	{
		System.out.println("open database connectivity");
	}
	@AfterSuite
	public void As()
	{
		System.out.println("close database connectivity");
	}
	@BeforeTest
	public void bt()
	{
		System.out.println("pre-conditions");
	}
	@AfterTest
	public void at()
	{
		System.out.println("post-conditions");
	}
	@BeforeClass
	public void bc() throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/orangeHRM.properties");
		Properties p=new Properties();
		p.load(file);
		
		String BROWSER = p.getProperty("Browser");
		
		
		if(BROWSER.contains("chrome"))
		{
			driver= new ChromeDriver();
			
		}
		if(BROWSER.contains("edge"))
		{
			driver= new EdgeDriver();
		}
		if(BROWSER.contains("firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass
	public void ac()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	@BeforeMethod
	public void loginTest() throws IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/orangeHRM.properties");
		Properties p=new Properties();
		p.load(file);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		String URL=p.getProperty("URL");
		String Username=p.getProperty("username");
		String Password=p.getProperty("password");
		
		driver.get(URL);
		OrangeHrmLoginpage o=new OrangeHrmLoginpage(driver);
		o.getUser(Username);
		o.getPass(Password);
		o.getSubmit();
		
		 
	}
	
	
	@AfterMethod
	public void am()
	{
		System.out.println("logout execution");
	}

}
