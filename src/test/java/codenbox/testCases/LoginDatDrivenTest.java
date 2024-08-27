package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import codenbox.testBase.Base;
import codenbox.utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginDatDrivenTest extends Base {
	
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"Regression"})
	public void verify_loginDDT(String userName, String password, String expResult) {
		
		logger.info("****Starting Login Test****");	
		// homepage 
		HomePage hm=new HomePage(driver);
		logger.info("Clicked on My Account Link");	
		hm.clickMyAccount();
		logger.info("Clicked on My Login Link");	
		hm.clickLogin();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering login email");
		lp.setEmail(userName);
		logger.info("Entering login password");
		lp.setPassword(password);
		logger.info("Clicking login button");
		lp.clickLoginBtn();
		
		MyAccountPage myact=new MyAccountPage(driver);
		boolean targetPage=myact.isMyAccountExist(); // true or false 
		
		/* Data is invalid: 
		 * login success -> logout : test fail 
		 * login failed ->  test pass
		 * Data is valid: 
		 * login success -> logout : test pass
		 * login failed ->  test fail
		 */
		logger.info("***validation for invalid result ***");
		if (expResult.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				myact.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("***validation for valid result ***");
		if (expResult.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				myact.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		logger.info("***completed LoginDDTest ***");	
	}

}
