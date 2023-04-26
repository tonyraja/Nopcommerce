package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void account_registration()
	{
		logger.info("Starting ***Registrationpage****");
		HomePage hp=new HomePage(driver);
		
		hp.clkmyregister();
		
		logger.info("*****Click on register*****");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("*****Enter valid Details*****");
		regpage.setgender();
		regpage.setfirstname(randomstring().toUpperCase());
		regpage.setlastname(randomnumber().toUpperCase());
		regpage.setday("5");
		regpage.setmonth("March");
		regpage.setyear("1993");
		regpage.setemail(randomstring()+"@gmail.com");
		regpage.setpassword("test@123");
		regpage.setconfpassword("test@123");
		
		regpage.clkregister();
		
		logger.info("*****Get Validation*****");
		String confmsg=regpage.getconfmsg();
		
		Assert.assertEquals(confmsg, "Your registration completed","Not Getting Expected Message");
		
	}
	
}
