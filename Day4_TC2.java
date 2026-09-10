package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zomato {
	public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.zomato.com/bangalore/delivery");
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        
        WebElement frame1 = driver.findElement(By.id("auth-login-ui"));
         driver.switchTo().frame(frame1);
         
        WebElement phno = driver.findElement(By.cssSelector("[placeholder='Phone']"));
        phno.sendKeys("1234567890");
        
        
        driver.switchTo().defaultContent();
        
        WebElement text = driver.findElement(By.tagName("h6"));
        System.out.println(text.getText());
        
        
        
 
        
        
        
        

}
}
