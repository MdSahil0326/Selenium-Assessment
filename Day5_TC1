package Framework;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assessment11 {
	public static void main(String[] args) throws Exception {
		// Step 1: Read data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT/Data.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String email = p.getProperty("email");
		String password = p.getProperty("password");
		// Step 2: Launch browser
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		// Step 3: Navigate to application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		// Step 4: Click Login
		driver.findElement(By.linkText("Log in")).click();
		// Step 5: Enter email and password
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		// Step 6: Click Login button
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}
}
