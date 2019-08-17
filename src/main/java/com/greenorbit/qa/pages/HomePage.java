package com.greenorbit.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.greenorbit.qa.base.TestBase;
import com.greenorbit.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Welcome Super')]")
	WebElement pageHeadingLabel;
	
	@FindBy(xpath="//a[@class='adminTitleLinkHelp']")
	WebElement helpLink;
	
	@FindBy(xpath="//a[@class='adminTitleLinkAbout']")
	WebElement aboutLink;
	
	@FindBy(xpath="//a[contains(text(),'Website Users')]")
	WebElement webSiteUserMenu;
	
	@FindBy(xpath="//a[contains(text(),'Add Website User')]")
	WebElement addWebsiteUserLink;
	
	//Initialize the objects mentioned above 
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Validate the title of Home Page
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
		//Verify Page Heading is 'Welcome Super'
	public boolean verifyPageHeading()
	{
		TestUtil.switchToFrame("main");;
		return pageHeadingLabel.isDisplayed();
	}
	
	//Click on Help link
	public HelpPage clickOnHelpLink()
	{
		TestUtil.switchToFrame("main");
		helpLink.click();
		return new HelpPage();
	}
	
	//Click on About link
	public AboutPage clickOnAboutLink() throws InterruptedException
	{
		Thread.sleep(5000);
		TestUtil.switchToFrame("main");
		aboutLink.click();
		return new AboutPage();
	}
	
	public WebsiteUserPage clickOnWebsiteUsersLink() throws InterruptedException
	{
		Thread.sleep(2000);
		TestUtil.switchToFrame("menu");
		webSiteUserMenu.click();
		return new WebsiteUserPage();
		
	}
	
	public WebsiteUserPage clickOnAddWebsiteUserLink() throws InterruptedException
	{
		//Thread.sleep(5000);
		//TestUtil.switchToFrame("menu");
        addWebsiteUserLink.click();
		return new WebsiteUserPage();
	}

	
/*	//If we want check the checkbox of Dynamic table, use below code. if xpath contains hard value, instead of that hard value we
	used 'Name' parameter and passed that parameter to thebelow function.,So in this case we have not user FindBy at the top and we are using
	below diver.FindByElements method
	public void selectContactsByName(String Name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id]")).click();
	}
	
	Now in testcase use below code
	public void selectContactTest()
	{
	contactPage.selectContactsByName("test2 test2")
	
	//in above code, contactPage is object of ContactPage class and "test2 tes2" is the value of 'Name' parameter which is passing to method
	 'selectContactsByName'.
	 * 
	}
	*/

}
