package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	
/*	
	public HomePageTest()    // No need of this class const and super keyword, it will automatically called super class const.
	{
		super();	
	}*/
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();	
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePageTitleTest()
	{
	 String homePageTitle= hp.verifyHomePageTitle();
	 Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page title not matched."); // msg will be printed if test case failed.
	}
	
	@Test(priority=2,enabled=false)
	public void verifyUserNameTest()
	{
	Assert.assertTrue(hp.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	 public void verifyContactsLinkTest()
	 {
		 cp =hp.clickOnContactsLink();
	 }
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	

}
