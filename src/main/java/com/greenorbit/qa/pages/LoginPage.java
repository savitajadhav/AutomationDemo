package com.greenorbit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greenorbit.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory/ Object Repository/ Page objects
	@FindBy(name="textUsername")
	WebElement username;
	
	@FindBy(name="textPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@name='LoginUserName']")
	WebElement adminname;
	
	@FindBy(xpath="//input[@name='LoginPassword']")
	WebElement adminpwd;
	
	//Initializing the page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	//Verify the title of the page
	public String validateLoginPageTitle()
	{
		return(driver.getTitle());
	}
	
	//Enter the credentials and click on login button
	public HomePage login(String uname, String pwd, String aname, String apwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
	    loginBtn.click();
	    adminname.sendKeys(aname);
	    adminpwd.sendKeys(apwd);
	    loginBtn.click();
	    return new HomePage();
	}

}
