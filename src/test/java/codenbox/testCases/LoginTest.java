package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import codenbox.testBase.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTest extends Base{
	
	@Test (groups= {"Regression"})
	public void verify_login() {
		logger.info("****Starting Login Test****");	
		// homepage 
		HomePage hm=new HomePage(driver);
		logger.info("Clicked on My Account Link");	
		hm.clickMyAccount();
		logger.info("Clicked on My Login Link");	
		hm.clickLogin();
		
		
		//login page
		LoginPage lp=new LoginPage(driver);
		//lp.setEmail("test@codenbox.com");
		logger.info("Entered email for login");
		lp.setEmail(prop.getProperty("myEmail"));
		logger.info("Entered password for login");
		lp.setPassword(prop.getProperty("myPassword"));
		logger.info("Clicked on login button for login function");
		lp.clickLoginBtn();
		
		//my account page 
		MyAccountPage myact=new MyAccountPage(driver);
		logger.info("account page verification");
		SoftAssert sa=new SoftAssert();
		
		myact.isMyAccountExist(); //true 
		sa.assertTrue(myact.isMyAccountExist());//false
		//System.out.println("LoginTest failed"); // will not execute
		logger.info("Login Test failed");
		sa.assertAll();	
		
	}

}
