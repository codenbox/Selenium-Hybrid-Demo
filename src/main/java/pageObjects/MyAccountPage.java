package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseComponents {
	
	public MyAccountPage (WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountText;
	
	@FindBy(xpath="(//a[@class='list-group-item'][text()='Logout'])[1]")
	WebElement logout; 
	
	// action methods
	
	public boolean isMyAccountExist() {
		try {
		return myAccountText.isDisplayed();  //true
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		logout.click();
	}
	
}
