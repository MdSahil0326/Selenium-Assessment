package Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day2_TC2 {
	public static void main(String[] args) throws InterruptedException {
		//create a  driver object
		WebDriver driver= new ChromeDriver();
		//maximize the window
		driver.manage().window().maximize();
		//Use implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//navigate to facebook application 
		driver.get("https://www.facebook.com/");
		
		//Capture the location
		Point Loc = driver.findElement(By.xpath("//span[text()='Create new account']")).getLocation();
      	System.out.println(Loc);
      	
      	
      	//get dom attributes 
        WebElement email = driver.findElement(By.name("email"));
        Thread.sleep(2000);
        System.out.println("------Before Entering email id-----------");
        System.out.println(email.getDomAttribute("value"));
		System.out.println(email.getDomProperty("value"));
		Thread.sleep(2000);
		System.out.println("-------------After entering email id---------------");
		email.sendKeys("hawkeye123@gmail.com");
		System.out.println(email.getDomAttribute("value"));
		System.out.println(email.getDomProperty("value"));
		
		//click on create account button 
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		
		WebElement  src = driver.findElement(By.xpath("//div[@role='none']/descendant::span[text()='Submit']"));
		//size
		System.out.println("--------------SIZE------------------");
		System.out.println(src.getSize());
		System.out.println(src.getSize().getHeight());
		System.out.println(src.getSize().getWidth());
		
		//css
		System.out.println("------------------css-Value--------------");
		System.out.println("Color: "+src.getCssValue("color"));
		System.out.println("Background-color: "+src.getCssValue("background-color"));
		System.out.println("Font-Family: "+src.getCssValue("font-family"));
		
		
		
		
      	
      
      	
		
		

}
}
