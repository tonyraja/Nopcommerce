package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement login;
	
	
	public void clkmyregister()
	{
		register.click();
	}
	
	
	public void clkmylogin()
	{
		login.click();
	}
}
