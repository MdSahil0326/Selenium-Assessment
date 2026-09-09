package Assessment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Day2_TC3 {
	public static void main(String[] args) throws InterruptedException, IOException {
		//create a  driver object
		WebDriver driver= new ChromeDriver();
		//maximize the window
		driver.manage().window().maximize();
		//Use implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//navigate to Demoweb shop application 
		driver.get("https://demowebshop.tricentis.com/");
		//find add to cart button by axes
		WebElement addtocart = driver.findElement(By.xpath("//img[@alt=\"Picture of 14.1-inch Laptop\"]/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']"));
		System.out.println("Add to cart button size "+addtocart.getSize());
		Thread.sleep(2000);
		//click on add to cart 
		addtocart.click();
		
		Thread.sleep(2000);
		//click on shopping cart 
		WebElement shoppingcart = driver.findElement(By.xpath("//a[@class='ico-cart' and text()='Shopping cart']"));
		shoppingcart.click();
		
		//check is selected or not 
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='removefromcart']"));
		System.out.println("CheckBox is Selected ??  > "+checkbox.isSelected());
		Thread.sleep(2000);
		// use get rect to checkbox 
		System.out.println(checkbox.getRect());
		
		
		
		
		
		//find apply coupon
		WebElement applycoupon = driver.findElement(By.xpath("//input[@value='Apply coupon']"));
	try {	
		WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
		if(message.isDisplayed()) {
			System.out.println("Message is displayed");
		}
		} catch(Exception e) {
			System.out.println("----Before clicking -------");
			System.out.println("Not Displayed ");
		}
		
        applycoupon.click();
		WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
		Thread.sleep(2000);
		if(message.isDisplayed()) {
			System.out.println("------After Clicking coupon----- ");
			System.out.println("Message is displayed =  "+message.getText());
		}
		else
			System.out.println("Message is not displayed ");
		
		WebElement ref = driver.findElement(By.xpath("//a[@class='product-name']"));
		WebElement laptop = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(ref));
		
		File src = laptop.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/Laptop.jpeg");
		FileHandler.copy(src, dest);
		
		
}}
