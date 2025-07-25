package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp) {
		logger.info("*****Starting of TC003_LoginDDT****");
	try {
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	MyAccountPage myAccount=new MyAccountPage(driver);
	boolean targetPage=myAccount.isMyAccountPageExists();
	if(exp.equalsIgnoreCase("valid")) {
		if(targetPage) {
			
			myAccount.clickLogout();
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
	else {
		if(!targetPage) {
			Assert.assertFalse(false);
			
		}else {
			myAccount.clickLogout();
			Assert.assertFalse(true);
			
		}
		
	}
	}
	catch (Exception e) {
		Assert.fail();
	}
	finally {
		logger.info("******End of the test case TC003_LoginDDT*******");
	}
	
	}
}

