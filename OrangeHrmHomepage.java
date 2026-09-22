package pomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmHomepage {
  WebDriver driver;

  public OrangeHrmHomepage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements( driver,this);
  }
  @FindBy(xpath = "//span[text()='Recruitment']")
  private WebElement Recuritment;
  
  @FindBy(xpath = "//span[text()='My Info']")
  private WebElement MyInfo;
  
  @FindBy(xpath = "(//span[@class='oxd-userdropdown-tab'])")
  private WebElement logoutdd;
  
  @FindBy(xpath = "(//ul[@class='oxd-dropdown-menu'])/descendant::a[text()='Logout']")
  private WebElement logoutClick;
  
 @FindBy(xpath = "//span[text()='Buzz']")
 private WebElement Buzz;
  
  public void getRecuritment() {
	Recuritment.click();
  }
  public void getMyInfo() {
		MyInfo.click();
	  }
  public void getLogOutDd() {
		logoutdd.click();
	  }
  public void getLogoutClick()
  {
	  logoutClick.click();
  }
  
  public void getBuzzClick() {
	  Buzz.click();
  }
  
  
  
  
  
  
}
