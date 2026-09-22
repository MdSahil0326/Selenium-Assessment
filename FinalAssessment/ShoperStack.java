package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoperStack {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		
		driver.findElement(By.xpath("//span[text()='CROCS']")).click();

		driver.findElement(By.id("Check Delivery")).sendKeys("583123");
		
		 WebElement ref = driver.findElement(By.id("Check"));
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.elementToBeClickable(ref));
		 ref.click();
		 
		 String text=driver.findElement(By.id("Check Delivery-helper-text")).getText();
		 System.out.println(text);
		
		
	}

}
