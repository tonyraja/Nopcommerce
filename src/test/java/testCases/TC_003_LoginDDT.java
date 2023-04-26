package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class)
	public void test_loginDDT(String email, String password,String exp) {
		
		
		logger.info("**** Starting TC_003_LoginDDT ****");
		
		HomePage hp=new HomePage(driver);
		hp.clkmylogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(password);
		lp.btnlogin();
		
MyAccountPage myact=new MyAccountPage(driver);
		
		boolean targetpage=myact.myaccountexist();
		
		Assert.assertEquals(targetpage, true, "Invalid Login Data");
		
		
		if(exp.equals("valid"))
		{
			if(targetpage==true)
		{
			myact.putlogout();
			Assert.assertTrue(true);
		}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("invalid"))
		{
			if(targetpage==true)
		{
			myact.putlogout();
			Assert.assertTrue(false);
		}
			else
			{
				Assert.assertTrue(true);
			}
		}
		logger.info("***Finished TC_003_LoginDDT****");
		
	}
	
}
