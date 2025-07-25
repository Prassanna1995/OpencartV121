package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
	


@Test(groups={"Regression","Master"})
public void verify_account_registration() {
	logger.info("***Starting TC001_AccountRegistration*****");
	logger.debug("This is a debug log message");
	try {
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked on MyAccount Link.. ");
	hp.clickRegister();
	logger.info("Clicked on Register Link.. ");
	RegistrationPage rp=new RegistrationPage(driver);
	logger.info("Providing customer details...");
	rp.setFirstName(randomString().toUpperCase());
	rp.setLastName(randomString().toUpperCase());
	rp.setEmail(randomString()+"@gmail.com");
	rp.setTelephone(randomNumber());
	String password=randomAlphaNumeric();
	rp.setPassword(password);
	rp.setConfirmPassword(password);
	rp.setPrivacyPolicy();
	rp.clickContinue();
	logger.info("Validating expected message..");
	String confirmationMessage=rp.getConfirmationMsg();
	if(confirmationMessage.equals("Your Account Has Been Created!")) 
	{
	logger.info("Test Passed");
	Assert.assertTrue(true);
	}
	else {
		logger.error("Test Failed");
		logger.debug("Debug logs...");
		Assert.assertTrue(false);
	}
	}
	catch (Exception e) {
		Assert.fail();
	}
	finally
	{
		logger.info("-------Test Completed-------");
	}
}

}
