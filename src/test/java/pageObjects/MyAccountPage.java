package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement myaccountpage;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logout;
	
	
	public boolean myaccountexist()
	{
	try
	{
		return(myaccountpage.isDisplayed());
	}
	catch(Exception e)
	{
		return(false);
	}
}
	
	
	
	public void putlogout()
	{
		logout.click();
	}
}