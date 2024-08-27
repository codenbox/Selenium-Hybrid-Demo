package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseComponents {
	
	public HomePage (WebDriver driver) {
		super(driver);
		
	}
	
	//locators 
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount; 
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement register;
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement login;
	
	//action methods
	
	public void clickMyAccount () {
		//driver.findElement(By.xpath("")).click();
		myAccount.click();
	}
	
	public void clickRegister () {
		//driver.findElement(By.xpath("")).click();
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	

}
