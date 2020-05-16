package com.iNetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.AddCustomerPage;
import com.iNetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust	=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
//		logger.info("customer details provided");
		
		addcust.custName("Harsha");
		addcust.custgender();
		addcust.custdob("05", "07", "1989");
		Thread.sleep(3000);
		
		addcust.custaddress("Mumbai");
		addcust.custcity("Mumbai");
		addcust.custstate("Maharashtra");
		addcust.custpinno("400708");
		addcust.custtelephoneno("1234567890");
		String email=randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("Test@123");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
//			logger.info("test case passed");
		}
		else
		{
//			logger.info("test case failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	

}
