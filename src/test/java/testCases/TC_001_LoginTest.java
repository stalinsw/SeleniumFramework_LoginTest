package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass
{
	private String email;
	private String pswd;
	private String uname;
	
	public void register_new_user() throws InterruptedException
	{
		try
		{
			LoginPage lp = new LoginPage(driver);
			lp.clickNewReg();
			AccountRegistrationPage ap = new AccountRegistrationPage(driver);
			email = randomString()+"@gmail.com";
			pswd = randomString();
			uname = randomString();
			ap.setFirstName(uname);// randomly generated name	
			ap.setEmail(email);// randomly generated email
			ap.setPassword(pswd);// randomly generated password of 8 characters		
			Thread.sleep(2);
			ap.clickSignUp();

			Assert.assertEquals("Log In", lp.getTextLoginBtn());
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}		
}
	
	@Test(priority=1)
	public void verify_login_valid_credentials() throws InterruptedException
	{
		try
		{
	        register_new_user();
	        Thread.sleep(2);
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName(email); //valid credentials
	        lp.setPassword(pswd);
	        lp.clickSubmit();
	        lp.clickAfterLogin();	        
	        Assert.assertEquals(uname, lp.getTextAfterLogin());
	        lp.clickLogout();
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}		
}
	@Test(priority=2)
	public void verify_login_invalid_credentials() throws InterruptedException
	{
		try
		{
			Thread.sleep(2);
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName(randomString());  //invalid credentials
	        lp.setPassword(randomString());
	        lp.clickSubmit();
	        Assert.assertEquals("Please enter a correct username and password. "
	        		+ "Note that both fields may be case-sensitive.", lp.getTextInvalidDataLogin());
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}		
}
	@Test(priority=3)
	public void verify_login_invalid_username() throws InterruptedException
	{
		try
		{
			Thread.sleep(2);
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName(email);
	        lp.setPassword(randomString());   //Registered username and invalid password
	        lp.clickSubmit();
	        Assert.assertEquals("Please enter a correct username and password. "
	        		+ "Note that both fields may be case-sensitive.", lp.getTextInvalidDataLogin());
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}		
}
	@Test(priority=4)
	public void verify_login_invalid_password() throws InterruptedException
	{
		try
		{
			Thread.sleep(2);
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName(randomString());         //registered password and invalid username
	        lp.setPassword(pswd);
	        lp.clickSubmit();
	        Assert.assertEquals("Please enter a correct username and password. "
	        		+ "Note that both fields may be case-sensitive.", lp.getTextInvalidDataLogin());
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}		
}
	@Test(priority=5)
	public void verify_login_empty_data() throws InterruptedException
	{
		try
		{
			Thread.sleep(2);
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName("");  //Login with invalid data
	        lp.setPassword("");
	        lp.clickSubmit();
	        Assert.assertEquals("Email: This field is required.", lp.getTextErrorEmptyMail());
	        Assert.assertEquals("Password: This field is required.", lp.getTextErrorPasswordMail());
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}	
}
	@Test(priority=6)
	public void verify_login_empty_username() throws InterruptedException
	{
		try
		{
			Thread.sleep(2);
	        LoginPage lp = new LoginPage(driver);
	        lp.setUserName("");   //Login with password and empty username
	        lp.setPassword(pswd);
	        lp.clickSubmit();
	        Assert.assertEquals("Email: This field is required.", lp.getTextErrorEmptyMail());
		}
		
	    catch (AssertionError e) {
		    System.out.println("AssertionError caught: " + e.getMessage());
		    Assert.fail();
		}	
}	

	@Test(priority = 7)
	public void verify_login_empty_pswd() throws InterruptedException {
		try {
			Thread.sleep(2);
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(email);    //Login with email and empty password
			lp.setPassword("");
			lp.clickSubmit();
			Assert.assertEquals("Password: This field is required.", lp.getTextErrorPasswordMail());
		}
	
		catch (AssertionError e) {
			System.out.println("AssertionError caught: " + e.getMessage());
			Assert.fail();
	}
}
	@Test(priority = 8)
	public void verify_login_space_data() throws InterruptedException {
		try {
			Thread.sleep(5);
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("           ");
			lp.setPassword("           "); //Login with spaces
			lp.clickSubmit();
			Assert.assertEquals("Email: This field is required.", lp.getTextErrorEmptyMail());
		}
	
		catch (AssertionError e) {
			System.out.println("AssertionError caught: " + e.getMessage());
			Assert.fail();
	}
}
}