package codenbox.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import codenbox.testBase.Base;
import codenbox.utilities.Retry;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationTest extends Base {
	
	@Test (groups= {"Sanity", "Regression"}, retryAnalyzer=Retry.class)
	public void verify_registration() {
		
		logger.info("***Starting RegistrationTest ***");
		
		HomePage hm=new HomePage(driver);
		logger.info("Clicked on My Account link");
		hm.clickMyAccount();
		
		logger.info("Clicked on register link");
		hm.clickRegister();
		
		
		RegistrationPage rg=new RegistrationPage(driver);
		
		logger.info("Entered customer registration details..");
	//	rg.setFirstName("Justin");
		rg.setFirstName(getRandomString().toUpperCase());
	//	rg.setLastName("Bieber");
		rg.setLastName(getRandomString().toUpperCase());
	//	rg.setEmail("testxyz@codenbox.com"); //randomly generated the email
		rg.setEmail(getRandomString()+"@codenbox.com");
	//	rg.setTelephone("123456789");
		rg.setTelephone(getRandomNum());
	//	rg.setPassword("abc34569");
	//	rg.setPassword("abc34569");
		String enterPassword=getRandomAlphaNumeric(); //store the same pass once & reuse
		rg.setPassword(enterPassword);
	//	rg.setConfirmPassword("abc34569");
		rg.setConfirmPassword(enterPassword);
		
		logger.info("Clicked on Privacy Policy ");
		rg.checkPolicy();
		
		logger.info("Clicked on Continue button ");
		rg.clickContinue();
		
		
		String actualmsg=rg.getConfirmationMsg();
		logger.info("validating expected Vs actual message");
//		SoftAssert sa= new SoftAssert();
//		softAssertion.assertEquals(actualmsg,"Your Account Has Been Created!!!");
		if(actualmsg.equalsIgnoreCase("Your Account Has Been Created!")) {
//			sa.assertTrue(true);
//			sa.assertAll();
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed");
			logger.debug("Debug logs..");
			Assert.fail();
//			sa.assertAll();
		}
	
		logger.info("**Completed RegistrationTest**");	
	}
	
}
