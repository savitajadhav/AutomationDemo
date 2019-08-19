/*
 * @Author : Savita Jadhav
 */
package com.greenorbit.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.greenorbit.qa.base.TestBase;
import com.greenorbit.qa.pages.HomePage;
import com.greenorbit.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login");
	}
	@Test(priority=2)
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("adminuname"), prop.getProperty("adminpwd"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
