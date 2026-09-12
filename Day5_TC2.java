package Framework;

import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assessment12 {
	public static void main(String[] args) throws Exception {
		// Step 1: Read data from Excel
		FileInputStream fis = new FileInputStream("D:\\Users\\Hp\\Downloads\\HRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String browser =  row.getCell(0).getStringCellValue();
		String url=row.getCell(1).getStringCellValue();
		String username = row.getCell(2).getStringCellValue();
		String password = row.getCell(3).getStringCellValue();
		
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Step 3: Navigate to OrangeHRM
		driver.get(url);
		// Step 4: Enter username
		driver.findElement(By.name("username")).sendKeys(username);
		// Step 5: Enter password
		driver.findElement(By.name("password")).sendKeys(password);
		// Step 6: Click Login
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		wb.close();
	}
}
