package com.npw.testscripts.gap;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.pageObjects.GapPageObject;
import com.om.framework.reporting.Reporting;

public class TC_004 extends BaseTest{
	
		private static boolean bStatus;
		public static void GetAllDetailsFromResidentialPage() throws IOException, HeadlessException, AWTException, InterruptedException
		{	
			Reporting.Functionality = "GAP";
			Reporting.Testcasename =  "Get all details from the Residential Page";
			//add a function to dynamically pick up the class name and add it as a test case name.				
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
				Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
				bStatus = GapPageObject.continueButton();
				if(!bStatus)
				{
					Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
					return;
				}
				Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
				bStatus = GapPageObject.getToKnowBetterStep("Title", "Prof", "RK", "9101114800086", "11/01/1991");
				if(!bStatus)
				{
					Reporting.logResults("Fail", "Enter/Fill the details in get To know better page.", "Unable to enter the details.. due to" + Messages.errorMsg);
					return;
				}
				Reporting.logResults("Pass", "Enter/Fill the details in get To know better page.", "Succesfully entered the details in get To know better page.");	
				bStatus = GapPageObject.continueButton();
				if(!bStatus)
				{
					Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
					return;
				}
				Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
				
				//Enter details on where do you live page
				bStatus = GapPageObject.whereDoYouLiveStep("6$$$", "555565666$$$", "`56565655", "#$$$$$", "^&^^gg");
				if(!bStatus)
				{
					Reporting.logResults("Fail", "Enter/Fill the details in where do you live page", "Unable to enter the details.. due to" + Messages.errorMsg);
					return;
				}
				Reporting.logResults("Pass", "Enter/Fill the details in where do you live page", "Succesfully entered the details in where do you live page");	
				
				
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
				
			}
			}

}
