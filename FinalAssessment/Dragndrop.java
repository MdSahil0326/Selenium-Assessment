package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragndrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		WebElement ele1 = driver.findElement(By.id("dragElement1"));
		WebElement ele2 = driver.findElement(By.id("dragElement2"));
		WebElement ele3 = driver.findElement(By.id("dragElement3"));
		WebElement ele4 = driver.findElement(By.id("dragElement4"));
		
		 WebElement dropzone1 = driver.findElement(By.id("dropZone1"));
		 System.out.print(dropzone1.getLocation().getX()+" "+dropzone1.getLocation().getY());
		 System.out.println();
		 
		 
		WebElement dropzone2 = driver.findElement(By.id("dropZone2"));
		System.out.print(dropzone2.getLocation().getX()+" "+dropzone2.getLocation().getY());
		System.out.println();
		
		
		
		Actions act= new Actions(driver);
		
		
		act.dragAndDropBy(ele2, 778, 131);
		
		act.dragAndDropBy(ele4, 778, 131);
		Thread.sleep(2000);
		
		act.dragAndDropBy(ele1, 778, 347);
		Thread.sleep(2000);
		
		act.dragAndDropBy(ele3, 778, 347);
		
		
		

}
}