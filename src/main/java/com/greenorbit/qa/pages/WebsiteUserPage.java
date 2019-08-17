package com.greenorbit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.greenorbit.qa.base.TestBase;
import com.greenorbit.qa.util.TestUtil;

public class WebsiteUserPage extends TestBase {

	@FindBy(xpath="//div[@class='adminTitleText']")
	WebElement websiteUserLabel;
	
	
	@FindBy(xpath="//input[@name='GivenName']")
    WebElement givenName;
    
    @FindBy(xpath="//input[@name='Surname']")
	WebElement surName;
    
    @FindBy(xpath="//input[@name='EmailAddress']")
    WebElement email;
    
    @FindBy(xpath="//input[@name='AddUserButtons_Next']")
    WebElement nextBtn;
    
    @FindBy(xpath="//input[@name='Username']")
    WebElement userName;
	
    @FindBy(xpath="//input[@name='Password']")
    WebElement password;
    
    @FindBy(xpath="//input[@name='AddUserButtons_Finish']")
    WebElement finishBtn;
    
    public WebsiteUserPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
	public boolean verifyWebsiteUserLabel()
	{   
	   //TestUtil.switchToFrame("main");
	   return websiteUserLabel.isDisplayed();
	}
	
	
	public WebsiteUserPage createNewWebsiteUser(String fname, String lname, String mail, String uname, String pwd)
	{
		givenName.sendKeys(fname);
		surName.sendKeys(lname);
		email.sendKeys(mail);
		nextBtn.click();
		userName.clear();
		userName.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
		nextBtn.click();
		nextBtn.click();
		finishBtn.click();
		return new WebsiteUserPage();
	}
	
}
