package com.npw.testscripts.gap;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.pageObjects.GapPageObject;
import com.om.framework.reporting.Reporting;

public class TC_003 extends BaseTest{

	private static boolean bStatus;
	
	
	@Test
	public static void getAllValidatiuonsStepOne() throws IOException, HeadlessException, AWTException, InterruptedException
	{	
		Reporting.Functionality = "GAP";
		Reporting.Testcasename = "Get all validations from the GREAT DECISION page";
		try
		{
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
		//Enter invalid details 
		bStatus = GapPageObject.greateDecisionStep("978767", "23432434", "hsbd", "rkaur445555");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter invalid details on great decision step.", "Unable to add details  on great decision step due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter invalid details on great decision step.", "Unable to add details  on great decision step due to");
		//Get all validations
		bStatus = GapPageObject.getAllValidationMessages("GreatDecisionPage");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Get all validations on great decision step.", "Unable to get all validations on  great decision step due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Get all validations on great decision step.", "All validations successfully matched on GreatDEcision Step");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporting.logResults("Fail", "Something happened with the testcase", "Failed");
		}
		//Browser.closeCurrentBrowser(driver);
		
	}
}
