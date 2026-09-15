package Assessment;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6 {
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		FileInputStream file1=new FileInputStream("C:\\Users\\Lenovo\\Downloads\\Book3.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		
		
		String firstname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String middleName = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String lastname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		DataFormatter df = new DataFormatter();
		String employeeid = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(3));
		String username = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String password = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		String employeeName = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/Config.properties");
		Properties p=new Properties();
		p.load(file);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String user = p.getProperty("Username");
		String pass = p.getProperty("Password");
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(user,Keys.TAB,pass);
		driver.findElement(By.cssSelector("[type='submit']")).submit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[name='firstName']")).sendKeys(firstname,Keys.TAB,middleName,Keys.TAB,lastname,Keys.TAB,employeeid);
		driver.findElement(By.cssSelector("[class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(username,Keys.TAB,Keys.TAB,Keys.TAB,password,Keys.TAB,password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type='submit']")).submit();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys(username);
		WebElement dd = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]"));
		Robot robot=new Robot();
		dd.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(employeeName);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[role='listbox']")).click();
		WebElement dd1 = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]"));
		dd1.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		
		WebElement record = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[text()='" 
		                +username+ "']"));
		
		if (record.isDisplayed()) {

		    System.out.println("=================================");
		    System.out.println("TEST CASE PASSED");
		} else {

		    System.out.println("=================================");
		    System.out.println("TEST CASE FAILED");
		}
	}

}
