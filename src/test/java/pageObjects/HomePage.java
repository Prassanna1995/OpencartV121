package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath="(//a[normalize-space()='Register'])[1]") 
	WebElement linkRegister;
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	public void clickRegister() {
		linkRegister.click();
	}
	public void clickLogin() {
		linkLogin.click();
	}
}
