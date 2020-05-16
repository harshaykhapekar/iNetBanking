package com.iNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;
import com.iNetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException 
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
//		logger.info("username provided");
		lp.setPassword(pwd);
//		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			captureScreen(driver, "loginDDT");
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
//			logger.info("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
//			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
		
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{		
		String path=System.getProperty("user.dir")+"/src/test/java/com/iNetBanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
				
	}

}
