package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	@FindBy(name="Email")
	WebElement txtemail;
	
	@FindBy(name="Password")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement login;
	
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void btnlogin()
	{
		login.click();
	}
	
	
	
	
	
}
