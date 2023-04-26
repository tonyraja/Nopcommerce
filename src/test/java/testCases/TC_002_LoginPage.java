package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginPage extends BaseClass {
	

	@Test(groups= {"Sanity","Master"})
	public void loginpage()
	{
		HomePage hp=new HomePage(driver);
		logger.info("*****Click on My Login*****");
		hp.clkmylogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("*****Enter Login details*****");
		lp.setemail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		lp.btnlogin();
		
		logger.info("*****Check validation*****");
		MyAccountPage myact=new MyAccountPage(driver);
		
		boolean targetpage=myact.myaccountexist();
		
		Assert.assertEquals(targetpage, true, "Invalid Login Data");
		
		logger.info("*****Finished Login Test*****");
	}
	
	
}
