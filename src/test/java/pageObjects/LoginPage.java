package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
		
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@id='username']") 
WebElement txtUsername;

@FindBy(xpath="//input[@id='password']") 
WebElement txtPassword;

@FindBy(xpath="//button[@type='submit']") 
WebElement btnLogin;

@FindBy(xpath="//span[@class='d-none d-sm-inline mx-1']") 
WebElement textAfterLogin;

@FindBy(xpath="//a[contains(text(),'New to Germany Is Calling?')]") 
WebElement btnnewRegister;

@FindBy(xpath="//li[contains(text(),'Please enter a correct username and password. Note')]")
WebElement textErrorInvalidData;

@FindBy(xpath="//a[@id='dropdownUser1']")
WebElement drpdwnAfterLogin;

@FindBy(xpath="//span[normalize-space()='Logout']")
WebElement btnLogout;

@FindBy(xpath="//li[normalize-space()='Email: This field is required.']")
WebElement textEmptyMail;

@FindBy(xpath="//li[normalize-space()='Password: This field is required.']")
WebElement textEmptyPassword;

public void setUserName(String uname) {
	txtUsername.sendKeys(uname);
}

public void setPassword(String pswd) {
	txtPassword.sendKeys(pswd);
}

public void clickSubmit() {
	btnLogin.click();
}

public String getTextLoginBtn(){
	return btnLogin.getText();
}

public String getTextAfterLogin() {
	return textAfterLogin.getText();
}

public void clickNewReg() {
	btnnewRegister.click();
}
public String getTextInvalidDataLogin() {
	return textErrorInvalidData.getText();
}
public void clickAfterLogin() {
	drpdwnAfterLogin.click();
}
public String getTextErrorEmptyMail() {
	return textEmptyMail.getText();
}
public String getTextErrorPasswordMail() {
	return textEmptyPassword.getText();
}
public void clickLogout() {
	btnLogout.click();
}
}