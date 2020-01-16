package com.npw.testscripts.gap;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.pageObjects.GapPageObject;
import com.om.framework.reporting.Reporting;

public class TC_002 extends BaseTest{
	
	private static boolean bStatus;
	
	@Test(priority=1)
	public static void getAllValidationsStepTwo() throws IOException, HeadlessException, AWTException, InterruptedException
	{	
		Reporting.Functionality = "GAP";
		Reporting.Testcasename = "Get all validations from the KNOW YOU BETTER page";
		try
		{
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
		bStatus = GapPageObject.greateDecisionStep("Ravneet", "kaur", "0645002939", "rkaur@oldmutual.com");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in Decision page.", "Unable to enter the details.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in Decision page.", "Succesfully entered the details in decision page.");	
		
		//Enter get to know better step details
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
		bStatus = GapPageObject.getToKnowBetterStep("Title", "Prof", "234434", "fdggg", "sdfdfgd");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in get To know better page.", "Unable to enter the details.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in get To know better page.", "Succesfully entered the details in get To know better page.");
	    //Get all validations
		bStatus = GapPageObject.getAllValidationMessages("KnowYouBetterPage");
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
		
	}
	}
