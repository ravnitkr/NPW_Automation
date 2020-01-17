package com.npw.testscripts.gap;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.lib.Utilities;
import com.om.framework.pageObjects.GapPageObject;
import com.om.framework.reporting.Reporting;

public class TC_004 extends BaseTest{
	
		private static boolean bStatus;
		private static Map<String,String> objMap;
		
		@Test
		public static void GetAllDetailsFromResidentialPage() throws IOException, HeadlessException, AWTException, InterruptedException
		{	
			Reporting.Functionality = "GAP";
			Reporting.Testcasename =  "Get all validations from the Residential Page";
			objMap = Utilities.readTestData((Utilities.getProjectPath() + "TestData.xls"), "GAP_Data", "TC_04_GetAllValidationsFromResidentialPage");
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
				bStatus = GapPageObject.greateDecisionStep(objMap.get("FirstName"), objMap.get("Surname"), objMap.get("Cellphone"), objMap.get("Email"));
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
				bStatus = GapPageObject.getToKnowBetterStep( objMap.get("Title"), objMap.get("TitleValue"), objMap.get("Initials"), objMap.get("RSAID"), objMap.get("DOB"));
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
				bStatus = GapPageObject.whereDoYouLiveStep(objMap.get("ApartmentNumber"), objMap.get("StreetName"), objMap.get("Suburb"), objMap.get("City"), objMap.get("PostalCode"));
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
				bStatus = GapPageObject.getAllValidationMessages("WhereDouYouLivePage");
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
