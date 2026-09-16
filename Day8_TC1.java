//Login Page POM File


package pomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='username']")
    private WebElement username;

    @FindBy(css = "[name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    public void enterUsername(String value) throws InterruptedException {
    	Thread.sleep(2000);
        username.sendKeys(value);
    }

    public void enterPassword(String value) {
        password.sendKeys(value);
    }

    public void clickLogin() {
        loginButton.click();
    }
}	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//RecruitmentPage Pom file

package pomUtilities;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitment;


    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement add;


    public void clickRecruitment() {

        wait.until(ExpectedConditions.elementToBeClickable(recruitment));

        recruitment.click();

        System.out.println("Recruitment clicked");
    }


    public void clickAdd() {

        wait.until(ExpectedConditions.elementToBeClickable(add));

        add.click();

        System.out.println("Add button clicked");
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//AddCandidatePage POM

package pomUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCandidatePage {

    WebDriver driver;
    WebDriverWait wait;

    public AddCandidatePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    // First Name
    @FindBy(name = "firstName")
    private WebElement firstname;


    // Middle Name
    @FindBy(name = "middleName")
    private WebElement middlename;


    // Last Name
    @FindBy(name = "lastName")
    private WebElement lastname;


    // Vacancy
    @FindBy(css = "[class='oxd-select-text-input']")
    private WebElement vacancy;


    // Email
    @FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
    private WebElement email;


    // Mobile
    @FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
    private WebElement mobile;


    // File
    @FindBy(xpath = "//input[@type='file']")
    private WebElement file;


    // Application Date
    @FindBy(xpath = "//label[text()='Date of Application']/../following-sibling::div//input")
    private WebElement applicationDate;


    // Save
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement save;


    // ---------------- METHODS ----------------


    public void enterFirstName(String value) {

        wait.until(ExpectedConditions.visibilityOf(firstname));

        firstname.sendKeys(value);
    }


    public void enterMiddleName(String value) {

        middlename.sendKeys(value);
    }


    public void enterLastName(String value) {

        lastname.sendKeys(value);
    }


    // Vacancy
    public void selectVacancy() throws AWTException {

        wait.until(ExpectedConditions.elementToBeClickable(vacancy));

        vacancy.click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    public void enterEmail(String value) {

        email.sendKeys(value);
    }


    public void enterMobile(String value) {

        mobile.sendKeys(value);
    }


    public void uploadFile(String value) {

        file.sendKeys(value);
    }


    public void enterApplicationDate(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(applicationDate));

        applicationDate.click();

        applicationDate.sendKeys(Keys.CONTROL + "a");

        applicationDate.sendKeys(value);
        Thread.sleep(2000);
        applicationDate.sendKeys(Keys.ENTER);
    }


    public void clickSave() {

        try {

            WebElement saveButton =
                    driver.findElement(By.xpath("//button[@type='submit']"));

            saveButton.click();

            System.out.println("Save button clicked");

        } catch (StaleElementReferenceException e) {

            System.out.println(
                "Candidate saved - page changed after Save click"
            );
        }
    }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//CandidatesPage pom file 

package pomUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CandidatesPage {

    WebDriver driver;
    WebDriverWait wait;

    public CandidatesPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    // Candidates tab
    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;


    // Job Title
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    private WebElement jobTitle;


    // Vacancy
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement candidateVacancy;


    // Hiring Manager
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
    private WebElement hiringManager;


    // Status
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[4]")
    private WebElement status;


    // Candidate Name
    @FindBy(css = "[placeholder='Type for hints...']")
    private WebElement candidateName;


    // From Date
    @FindBy(css = "[placeholder='From']")
    private WebElement fromDate;


    // Search
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement search;


    // Candidate record
    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
    private WebElement records;


    // ---------------- METHODS ----------------


    public void clickCandidates() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement candidatesButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Candidates']")
                )
        );

        candidatesButton.click();

        System.out.println("Candidates clicked");
    }


    // Job Title
    public void selectJobTitle() throws AWTException {

        wait.until(ExpectedConditions.elementToBeClickable(jobTitle));

        jobTitle.click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    // Vacancy
    public void selectVacancy() throws AWTException {

        wait.until(ExpectedConditions.elementToBeClickable(candidateVacancy));

        candidateVacancy.click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    // Hiring Manager
    public void selectHiringManager() throws AWTException {

        wait.until(ExpectedConditions.elementToBeClickable(hiringManager));

        hiringManager.click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    // Status
    public void selectStatus() throws AWTException {

        wait.until(ExpectedConditions.elementToBeClickable(status));

        status.click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    // Candidate Name
    public void enterCandidateName(String value) {

        wait.until(ExpectedConditions.visibilityOf(candidateName));

        candidateName.sendKeys(value);
    }


    // From Date
    public void enterFromDate(String value) {

        wait.until(ExpectedConditions.elementToBeClickable(fromDate));

        fromDate.click();

        fromDate.clear();

        fromDate.sendKeys(value);
    }


    // Search
    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(search));

        search.click();

        System.out.println("Search clicked");
    }


    // Verify candidate
    public void verifyCandidate(String candidateName) {

        WebElement candidate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                            "//div[contains(@class,'oxd-table-body')]"
                            + "//div[contains(normalize-space(),'"
                            + candidateName +
                            "')]"
                        )
                )
        );

        if (candidate.isDisplayed()) {

            System.out.println(
                    "PASS: Candidate " + candidateName + " is present in records."
            );

        } else {

            System.out.println(
                    "FAIL: Candidate " + candidateName + " is not present."
            );
        }
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Logout page POM file 


package pomUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;


    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logout;


    public void clickUserDropdown() {

        wait.until(ExpectedConditions.elementToBeClickable(userDropdown));

        userDropdown.click();
    }


    public void clickLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(logout));

        logout.click();

        System.out.println("Logged out successfully");
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





//Day8-src test java  Day 8 file
package Assessment;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomUtilities.AddCandidatePage;
import pomUtilities.CandidatesPage;
import pomUtilities.HomePage;
import pomUtilities.LoginPage;
import pomUtilities.RecruitmentPage;

public class Day8 {

    public static void main(String[] args)
            throws AWTException, InterruptedException, IOException {


        // Read properties file

        FileInputStream file =
                new FileInputStream(
                        "./src/test/resources/DDT/Day8.properties"
                );

        Properties p = new Properties();

        p.load(file);


        // Browser

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        driver.get(p.getProperty("url"));


        // =========================
        // LOGIN PAGE
        // =========================

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(p.getProperty("untf"));

        loginPage.enterPassword(p.getProperty("pwtf"));

        loginPage.clickLogin();


        // =========================
        // RECRUITMENT PAGE
        // =========================

        RecruitmentPage recruitmentPage =
                new RecruitmentPage(driver);

        recruitmentPage.clickRecruitment();

        recruitmentPage.clickAdd();


        // =========================
        // ADD CANDIDATE PAGE
        // =========================

        AddCandidatePage addCandidatePage =
                new AddCandidatePage(driver);

        addCandidatePage.enterFirstName(
                p.getProperty("firstname")
        );

        addCandidatePage.enterMiddleName(
                p.getProperty("middlename")
        );

        addCandidatePage.enterLastName(
                p.getProperty("lastname")
        );

        addCandidatePage.selectVacancy();

        addCandidatePage.enterEmail(
                p.getProperty("email")
        );

        addCandidatePage.enterMobile(
                p.getProperty("mobile")
        );

        addCandidatePage.uploadFile(
                p.getProperty("file")
        );

        addCandidatePage.enterApplicationDate(
                p.getProperty("applicationDate")
        );


        // SAVE

        addCandidatePage.clickSave();


        // =========================
        // CANDIDATES PAGE
        // =========================

        CandidatesPage candidatesPage =
                new CandidatesPage(driver);

        candidatesPage.clickCandidates();

        candidatesPage.selectJobTitle();

        candidatesPage.selectVacancy();

        candidatesPage.selectHiringManager();

        candidatesPage.selectStatus();

        candidatesPage.enterCandidateName(
                p.getProperty("candidateName")
        );

        candidatesPage.enterFromDate(
                p.getProperty("fromDate")
        );

        candidatesPage.clickSearch();


        // =========================
        // VERIFY
        // =========================

        candidatesPage.verifyCandidate(
                p.getProperty("candidateName")
        );


        // =========================
        // LOGOUT
        // =========================

        HomePage homePage = new HomePage(driver);

        homePage.clickUserDropdown();

        homePage.clickLogout();


        // Close browser

        driver.quit();
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//DAY -8 Properties file 

url=https://opensource-demo.orangehrmlive.com/
untf=Admin
pwtf=admin123

firstname=Ram
middlename=Charan
lastname=RC

email=RC@gmail.com
mobile=9876543210

file=C:/Users/Lenovo/Downloads/9789355422415_toc.pdf

applicationDate=2026-13-06
candidateName=Ram Charan RC
fromDate=2026-13-06
