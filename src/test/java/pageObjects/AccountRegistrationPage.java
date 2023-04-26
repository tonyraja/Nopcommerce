package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {
	
	
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[@class='male']")
	WebElement male;
	
	@FindBy(name="FirstName")
	WebElement fname;
	
	@FindBy(name="LastName")
	WebElement lname;
	
	@FindBy(name="DateOfBirthDay")
	WebElement day;
	
	Select birthday=new Select(day);
	
	@FindBy(name="DateOfBirthMonth")
	WebElement month;
	
	Select mon=new Select(month);
	
	@FindBy(name="DateOfBirthYear")
	WebElement year;
	
	Select yr=new Select(year);
	
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(name="ConfirmPassword")
	WebElement confpassword;
	
	@FindBy(name="register-button")
	WebElement register;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement confmsg;
	
	
	public void setgender()
	{
		male.click();
	}
	
	public void setfirstname(String firstname)
	{
		fname.sendKeys(firstname);
	}
	
	public void setlastname(String lastname)
	{
		lname.sendKeys(lastname);
	}
	
	public void setday(String dy)
	{
		birthday.selectByValue(dy);
	}
	
	public void setmonth(String mth)
	{
		mon.selectByVisibleText(mth);
	}
	
	public void setyear(String setyr)
	{
		yr.selectByValue(setyr);
	}
	
	public void setemail(String eml)
	{
		email.sendKeys(eml);
	}
	
	public void setpassword(String firstpwd)
	{
		password.sendKeys(firstpwd);
	}
	
	public void setconfpassword(String confpwd)
	{
		confpassword.sendKeys(confpwd);
	}
	
	public void clkregister()
	{
		register.click();
	}
	
	public String getconfmsg()
	{
		try
		{
			return(confmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
