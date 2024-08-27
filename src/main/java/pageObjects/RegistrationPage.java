package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseComponents {

	// create constructor
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(css = "#input-email")
	WebElement email;

	@FindBy(css = "#input-telephone")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement policy;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// action methods
	public void setFirstName(String myFname) {
		firstName.sendKeys(myFname);
	}

	public void setLastName(String myLname) {
		lastName.sendKeys(myLname);
	}

	public void setEmail(String myEmail) {
		email.sendKeys(myEmail);
	}

	public void setTelephone(String myTelphone) {
		telephone.sendKeys(myTelphone);
	}

	public void setPassword(String myPass) {
		password.sendKeys(myPass);
	}

	public void setConfirmPassword(String myPass) {
		confirmPassword.sendKeys(myPass);
	}

	public void checkPolicy() {
		policy.click();
	}

	public void clickContinue() {
		continueBtn.click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
