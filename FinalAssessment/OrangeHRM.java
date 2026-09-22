package FinalAssessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import baseClassUtility.BaseClassOrangeHrm;
import pomUtilities.OrangeHrmHomepage;
import pomUtilities.OrangeHrmViewBuzz;

public class OrangeHRM extends BaseClassOrangeHrm{

	@Test
	public void BuzzTest() throws Exception {
		
		OrangeHrmHomepage hp= new OrangeHrmHomepage(driver);
		 hp.getBuzzClick();
		 
		 FileInputStream file= new FileInputStream("src/test/resources/DDT/orangeHRM.properties");
		 Properties p=new Properties();
		 p.load(file);
		 
		  String Message = p.getProperty("message");
		 
		 OrangeHrmViewBuzz msgBox= new OrangeHrmViewBuzz(driver);
		 msgBox.getBox(Message);
		 Thread.sleep(2000);
		 msgBox.getPost();
		 }
	@Test
	public void VerifyPost() throws IOException {
		
		
		FileInputStream file= new FileInputStream("src/test/resources/DDT/orangeHRM.properties");
		 Properties p=new Properties();
		 p.load(file);
		  String Message = p.getProperty("message");

		  OrangeHrmHomepage hp= new OrangeHrmHomepage(driver);
		  hp.getBuzzClick();
			 
		  
		  
		OrangeHrmViewBuzz msgBox= new OrangeHrmViewBuzz(driver);
		msgBox.getrecentpost(Message);
		msgBox.verify(Message);
	
	
}}
