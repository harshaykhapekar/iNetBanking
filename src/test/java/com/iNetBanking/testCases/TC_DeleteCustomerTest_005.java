package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.DeleteCustomerPage;
import com.iNetBanking.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseClass{
	
	@Test
	public void deleteCustomer() throws InterruptedException {
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		DeleteCustomerPage delcust = new DeleteCustomerPage(driver);
		delcust.clickdelcust();
		delcust.delcustid("16100");
		delcust.custdelsubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
//			captureScreen(driver, "loginDDT");
			if(isAlertPresent()==true)
			{
				
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}	
			else
			{
				Assert.assertTrue(false);
//				driver.switchTo().defaultContent();
			}
//			logger.info("Login failed");
		}
//		else
//		{
//			driver .switchTo().alert().dismiss();
//			Assert.assertTrue(true);
////			logger.info("Login Passed");
//			lp.clickLogout();
//			Thread.sleep(3000);
//			
////			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//		}
		
	
	}
	
	

}
