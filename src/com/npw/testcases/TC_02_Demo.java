package com.npw.testcases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.npw.lib.GAP.GapNavigation;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.reporting.Reporting;

public class TC_02_Demo extends BaseTest
{
	private static boolean bStatus;
	
	@Test
	public static void testn() throws HeadlessException, IOException, AWTException
	{
		
		
		//bStatus =NavigateTo.appMenu("wealth");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Navigate to app menu Wealth", "Unable to navigate to Wealth application menu.. due to.. "+Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Navigate to app menu Wealth", "Succesfully navigated to Wealth application menu.. ");

		
		
	}

}
