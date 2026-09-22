package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoQspiders {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
	WebElement tog1 = driver.findElement(By.id("tog"));
	WebElement tog2 = driver.findElement(By.id("togg"));
	WebElement tog3 = driver.findElement(By.id("toggl"));
	WebElement tog4 = driver.findElement(By.id("toggler"));
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].removeAttribute('disabled');",tog1);
	js.executeScript("arguments[0].click()",tog1);
	js.executeScript("arguments[0].removeAttribute('disabled');",tog2);
	js.executeScript("arguments[0].click()",tog2);
	js.executeScript("arguments[0].removeAttribute('disabled');",tog3);
	js.executeScript("arguments[0].click()",tog3);
	js.executeScript("arguments[0].removeAttribute('disabled');",tog4);
	js.executeScript("arguments[0].click()",tog4);
	
	Thread.sleep(2000);
	driver.findElement(By.id("togglers")).click();
	
	String ord = driver.findElement(By.cssSelector("[class='text-lg text-orange-600 font-bold text-center']")).getText();
	
	if(ord.contains("ORDER PLACED")) {
		System.out.println("Order placed ");	
	}
	else
		System.out.println("Order not placed ");
	
	Thread.sleep(2000);
	driver.quit();
	
	
	
	
}	
}
