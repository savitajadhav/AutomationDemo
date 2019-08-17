package com.greenorbit.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.greenorbit.qa.base.TestBase;
import com.greenorbit.qa.pages.AboutPage;
import com.greenorbit.qa.pages.HelpPage;
import com.greenorbit.qa.pages.HomePage;
import com.greenorbit.qa.pages.LoginPage;
import com.greenorbit.qa.pages.WebsiteUserPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HelpPage helpPage;
	AboutPage aboutPage;
	WebsiteUserPage websiteUserPage;
	
	//Initialize the prop using superclass
	public HomePageTest()
	{
		super();
	}
  
	@BeforeMethod
	public void setUp()
	{
		initialization();//Initialize the browser
		LoginPage loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("adminuname"), prop.getProperty("adminpwd"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "GreenOrbit Administration", "Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyPageHeadingTest()
	{
		Assert.assertTrue(homePage.verifyPageHeading());
	}
	
	@Test(priority=3)
	public void clickOnHelpLinkTest() throws InterruptedException
	{
		Thread.sleep(2000);
		helpPage = homePage.clickOnHelpLink();
		
	}
	
	@Test(priority=4)
	public void clickOnAboutLinkTest() throws InterruptedException
	{
		Thread.sleep(2000);
		aboutPage = homePage.clickOnAboutLink();
	}
	
	@Test(priority=5)
	public void clickOnWebsiteUserTest() throws InterruptedException
	{
		Thread.sleep(2000);
		websiteUserPage = homePage.clickOnWebsiteUsersLink();
	}
	
	@Test(priority=6)
	public void clickonAddWebsiteUserTest() throws InterruptedException
	{
		Thread.sleep(2000);
		websiteUserPage = homePage.clickOnWebsiteUsersLink();
		websiteUserPage = homePage.clickOnAddWebsiteUserLink();
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
