package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		// click on the slide button 
		
		WebElement slider = driver.findElement(By.id("slide"));
		
		
		
		Actions act= new Actions(driver);
		act.clickAndHold(slider).moveByOffset(100, 0).perform();
		
		boolean verify = driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']")).isDisplayed();
		
		System.out.println("Verification : "+verify);
		
		
		
	}

}
