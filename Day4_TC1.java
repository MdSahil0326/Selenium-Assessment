package Demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com/");

        Thread.sleep(3000);

        // Find all elements on the page
        List<WebElement> links = driver.findElements(By.tagName("*"));

        // Number of elements
        int count = links.size();

        System.out.println("Total number of elements: " + count);

        // Count text fields

        for (WebElement ele : links) {

            String type = ele.getAttribute("type");

            if (type != null && type.equals("text")) {
            	   ele.sendKeys("Praveen");
            	   
            }
        }

    }
}
