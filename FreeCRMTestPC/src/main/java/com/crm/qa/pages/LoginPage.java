package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Below is the Object Repository or Page factory
	
	@FindBy(xpath="//span[text()=\"Log In\"]")
	@CacheLookup
	WebElement FirstBtn;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/span[3]/font")
	@CacheLookup
	WebElement crmLogo;
	
	
	@FindBy(xpath="//input[@name=\"email\"]")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//div[text()=\"Login\"]")
	@CacheLookup
	WebElement loginBtn;
	

	
	
// Initializing page objects.
	public LoginPage()      //7 On Object  creation for LoginPage class this const will invoke and initialize Obj repo with driver.
	{
		System.out.println("Inside LoginPage class const which will execute PageFactory method");
		PageFactory.initElements(driver, this);   // this = Current class object i.e. All WebElements are initialized with driver.
		System.out.println("Page Objects of LoginPage class initialized with driver now.. going back to Before Method");
	}
	
	
	
	public String validateLoginPageTitle()  //10
	{
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		FirstBtn.click();
		Thread.sleep(3000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		System.out.println("Login Successfull");
		return new HomePage(); 
		
	}
	

}
