package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{                           
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest()         // Due to inheritance it will goes to const of its parent class i.e TestBase class.
	{                          // 1) Execution begins here -> Goes to TestBase class constructor first then come back.
      System.out.println("LoginPageTest constructor: END");
	}
	
	@BeforeMethod
	public void setUp()      //3
	{
	System.out.println("BeforeMethod Started : going to execute 'initialization' method of TestBase class now..'");
	initialization();	//4     Will initialize browser.
	System.out.println("Creating Object of 'LoginPage' class, But again it will first goes to its 'Parent' TestBase const'");
	lp= new LoginPage();	//6 This is a minor loophole here-> It will go again for TestBase const and 
	System.out.println("'Before Method': END"); // come back to Loginpage const to initialize Obj Repo.
	}
	
	@Test(priority=1,enabled=false)
	public void loginPageTitleTest()     //8
	{
	   System.out.println("Inside First Test case");
       String title=lp.validateLoginPageTitle();  // 9 Goes to the LoginPage class and run method.
       Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
       System.out.println("First Test case: END");  // It will Assert that both the String should be equal.
	}                     
	
	
	@Test(priority=2,enabled=false)
	public void crmLogoImageTest()    // 11
	{
		System.out.println("Inside second Test case");
		boolean flag= lp.validateCRMImage();  // Check whether Logo is present on the page.
		Assert.assertTrue(flag); // If not present then it will fail the test
		System.out.println("Second Test case: END");
	}
	
	@Test(priority=3,enabled=true)
	public void loginTest() throws InterruptedException
	{
		System.out.println("Inside third Test case"); 
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password")); //13
		System.out.println("Third Test case: END");
		
	}
	
	@AfterMethod
	public void tearDown()   //12
	{
		System.out.println("Inside 'AfterMethod' annotation:Ending current test now");
		driver.quit();
	}
	
	
	

}
