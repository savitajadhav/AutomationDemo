/*
 * @Author  Savita Jadhav
 */
package com.greenorbit.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.greenorbit.qa.base.TestBase;
import com.greenorbit.qa.pages.HomePage;
import com.greenorbit.qa.pages.LoginPage;
import com.greenorbit.qa.pages.WebsiteUserPage;
import com.greenorbit.qa.util.TestUtil;

public class WebsiteUserPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	WebsiteUserPage websiteUserPage;
	static String sheetName = "WebsiteUsers";
	
	public WebsiteUserPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		LoginPage loginPage = new LoginPage();
		//WebsiteUserPage websiteUserPage = new WebsiteUserPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("adminuname"), prop.getProperty("adminpwd"));
		websiteUserPage= homePage.clickOnWebsiteUsersLink();
		
	}
	
	@Test(priority=1)
	public void verifyWebsiteUserPageTitle() throws InterruptedException
	{
		TestUtil.switchToFrame("main");
		Assert.assertTrue(websiteUserPage.verifyWebsiteUserLabel());
	}
	
	@Test(priority=2, dataProvider ="getGreenorbitTestData")
	public void verifyCreateNewWebsiteUser(String givenName, String surName, String email, String userName, String password) throws InterruptedException{
		
		websiteUserPage = homePage.clickOnAddWebsiteUserLink();
		TestUtil.switchToFrame("main");
	  //websiteUserPage.createNewWebsiteUser("test3", "user3", "testuser3@gmail.com", "testuser3", "password@123");
		websiteUserPage.createNewWebsiteUser(givenName, surName, email, userName, password);
	  
	}
	
	@DataProvider
	public static Object[][] getGreenorbitTestData() throws Exception{
		 Object data[][]  = TestUtil.getTestData(sheetName);
		 return data;
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
