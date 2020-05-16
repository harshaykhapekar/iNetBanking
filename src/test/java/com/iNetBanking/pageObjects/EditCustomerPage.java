package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement lnkeditcustomer;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement txtcustid;
	
	@FindBy(xpath="//input[@type='submit' and @name='AccSubmit' and @value='Submit']")
	@CacheLookup
	WebElement btneditsubmit;
	
	public void clickeditcust() {
		lnkeditcustomer.click();
	}
	
	public void custid(String custid) {
		txtcustid.sendKeys(String.valueOf(custid));
	}
	
	public void custeditsubmit() {
		btneditsubmit.click();
	}
	

}
