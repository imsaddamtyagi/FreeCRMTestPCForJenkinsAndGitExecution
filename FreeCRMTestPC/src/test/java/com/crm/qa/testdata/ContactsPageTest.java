package com.crm.qa.testdata;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	String sheetName="contacts";
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		lp = new LoginPage();	
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String fn,String ln, String mn) throws InterruptedException
	{
		System.out.println("Inside test");
		cp=hp.clickOnContactsLink();
		cp.createNewContact(fn,ln,mn);
		Thread.sleep(2000);
		System.out.println("Test Passed");
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
	  Object data[][]=TestUtil.getTestData(sheetName);
	  return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
