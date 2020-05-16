package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
WebDriver ldriver;
	
	public DeleteCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
	@CacheLookup
	WebElement lnkdelcustomer;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement txtdelcustid;
	
	@FindBy(xpath="//input[@type='submit' and @name='AccSubmit' and @value='Submit']")
	@CacheLookup
	WebElement btndelsubmit;
	
	public void clickdelcust() {
		lnkdelcustomer.click();
	}
	
	public void delcustid(String custid) {
		txtdelcustid.sendKeys(String.valueOf(custid));
	}
	
	public void custdelsubmit() {
		btndelsubmit.click();
	}

}
