package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[text()=\"Mohd Ahmad\"]")
	@CacheLookup
    WebElement userNameLabel;
	
	@FindBy(xpath="//span[text()=\"Contacts\"]")
	@CacheLookup
	WebElement contactsLink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();				
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();			
	}
	
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink()
	{
		contactsLink.click();
	}
	
	

}
