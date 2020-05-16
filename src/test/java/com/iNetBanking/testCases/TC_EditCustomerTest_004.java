package com.iNetBanking.testCases;

import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.EditCustomerPage;
import com.iNetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_EditCustomerTest_004 extends BaseClass {
	
	@Test
	public void editCustomer() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		EditCustomerPage editcust = new EditCustomerPage(driver);
		editcust.clickeditcust();
		editcust.custid("93233");
		editcust.custeditsubmit();
		
		boolean res=driver.getPageSource().contains("Edit Customer");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{
			logger.info("test case failed");
//			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	

}
