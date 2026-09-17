//// SauceDemoImplementation///////////////////////////////////////////////////////////////////////////////////////////////////////////

package keywordframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoImplementation {
	    WebDriver driver;
	    public void launchBrowser() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    public void openurl() {
	        driver.get("https://www.saucedemo.com/");
	    }

	    public void untf() {
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    }

	    public void pwtf() {
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    }
	    
	    public void login() {
	    	driver.findElement(By.id("login-button")).click();
	    }

	    public void closeBrowser() {
	        driver.quit();
	    }

}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//SauceDemoExecution/////////////////////////////////



package keywordframework;

public class SauceDemoExecution {
	SauceDemoImplementation k= new SauceDemoImplementation();
	
	public void executors(String keyword) {

        if (keyword.equals("LAUNCH_BROWSER")) {
            k.launchBrowser();
        }

        else if (keyword.equals("OPEN_URL")) {
            k.openurl();
        }

        else if (keyword.equals("USER_LOGIN")) {
            k.untf();
        }

        else if (keyword.equals("PASSWORD")) {
            k.pwtf();
        }
        
        else if(keyword.equals("LOGIN")) {
        	k.login();
        }

        else if (keyword.equals("CLOSE_BROWSER")) {
            k.closeBrowser();
        }
        
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////SauceDemo main /////////////////////////////////////////////////////////////////////////
package keywordframeworkImplementation;

import keywordframework.SauceDemoExecution;

public class SauceDemo {
	public static void main(String[] args) throws InterruptedException {

		SauceDemoExecution e= new SauceDemoExecution();

		e.executors("LAUNCH_BROWSER");
		e.executors("OPEN_URL");
		e.executors("USER_LOGIN");
		e.executors("PASSWORD");
		e.executors("LOGIN");
		Thread.sleep(3000);
		e.executors("CLOSE_BROWSER");
		}
}

