package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

public AccountRegistrationPage(WebDriver driver)
{
	super(driver);
}

@FindBy(xpath="//input[@id='first_name']") 
WebElement txtFirstname;

@FindBy(xpath="//input[@id='username']") 
WebElement txtEmail;

@FindBy(xpath="//input[@id='password']") 
WebElement txtPassword;

@FindBy(xpath="//button[@type='submit']")
WebElement btnSignup;

public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}

public void setEmail(String mail) {
	txtEmail.sendKeys(mail);
}

public void setPassword(String pswd) {
	txtPassword.sendKeys(pswd);
}

public void clickSignUp() {
	btnSignup.click();
}
}