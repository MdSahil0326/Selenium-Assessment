package Demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bigBasket {
	public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bigbasket.com/");
        WebElement search = driver.findElement(By.tagName("input")); 
        Thread.sleep(2000);
        search.sendKeys("carrot");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        
        
        
        try {
        //WebElement cart = driver.findElement(By.xpath("//img[@title='fresho! Carrot - Organically Grown 1 kg']/ancestor::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 bFjDCO']/descendant::button[text()='Add']"));
         WebElement cart = driver.findElement(By.xpath("//button[text()='Add']"));
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",cart);
        }
        
        
        
        catch(Exception e) {
            WebElement cart = driver.findElement(By.xpath("//button[text()='Add']"));
            Thread.sleep(3000);
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()",cart);
        }
        
        
        
        
//        for(WebElement ele:cart) {
//        	 js.executeScript("arguments[0].click()",ele);
//        	break;
//        }
        
        
       
        
}}
