package pomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class OrangeHrmViewBuzz {
	WebDriver driver;
	
		public OrangeHrmViewBuzz(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}

		
@FindBy(css = "[class='oxd-buzz-post-input']")
private WebElement box;

@FindBy(css="[type='submit']")
private WebElement post;

@FindBy(xpath ="(//div[contains(@class,'orangehrm-buzz-post-body')])[1]")
private WebElement feed;




public void getBox(String value ) {
	box.sendKeys(value);;
}

public void getPost() {
	post.click();
}	

public boolean getrecentpost(String text) {
	String txt=feed.getText();
	return txt.equals(text);
}

public void verify(String args) {
	Assert.assertTrue(getrecentpost(args));
	System.out.println("verified");
}
}



