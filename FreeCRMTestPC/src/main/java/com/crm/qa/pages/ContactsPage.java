package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	

	
	@FindBy(xpath="//a[@href=\"/contacts/new\"]")
	@CacheLookup
	WebElement CreateNewContactLink;
	
	@FindBy(xpath="//input[@name=\"first_name\"]")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@name=\"last_name\"]")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//input[@name=\"middle_name\"]")
	@CacheLookup
	WebElement mdlName;
	
	
	@FindBy(xpath="//button[@class=\"ui linkedin button\"]")
	@CacheLookup
	WebElement saveBtn;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	

	public void  createNewContact(String ftname,String ltname,String mdname) throws InterruptedException 
	{
		CreateNewContactLink.click();
		Thread.sleep(4000);
		System.out.println("Entering details");
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		mdlName.sendKeys(mdname);
		saveBtn.click();
		System.out.println("Details Entered");
		
	}
	
	
	

}
