package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;@Test
public class TC002_LoginTest extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
	logger.info("****Starting the TC_002_LoginTest ****");
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	MyAccountPage myAccount=new MyAccountPage(driver);
	Assert.assertEquals(myAccount.isMyAccountPageExists(), true,"Login Failed");
	logger.info("******End of TC_002_LoginTest *************");
}
}
