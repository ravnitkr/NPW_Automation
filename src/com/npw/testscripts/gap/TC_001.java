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

public class TC_001 extends BaseTest
{
	private static boolean bStatus;
	private static Map<String,String> objMap;
	
	@Test
	public static void submitApp() throws IOException, HeadlessException, AWTException, InterruptedException
	{	
		Reporting.Functionality = "GAP";
		Reporting.Testcasename = "GAP Positive Flow Test Case";
		//add a function to dynamically pick up the class name and add it as a test case name.				
		try
		{
			
		//Get data from Excel sheet
		objMap = Utilities.readTestData((Utilities.getProjectPath() + "TestData.xls"), "GAP_Data", "TC_01_GapSubmitWholeApplication");	
		
		//Enter decision page details
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		bStatus = GapPageObject.greateDecisionStep(objMap.get("FirstName"), objMap.get("Surname"), objMap.get("Cellphone"), objMap.get("Email"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in Decision page.", "Unable to enter the details.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in Decision page.", "Succesfully entered the details in decision page.");	
		
		//Enter get to know better step details
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
		bStatus = GapPageObject.getToKnowBetterStep( objMap.get("Title"), objMap.get("TitleValue"), objMap.get("Initials"), objMap.get("RSAID"), objMap.get("DOB"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in get To know better page.", "Unable to enter the details.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in get To know better page.", "Succesfully entered the details in get To know better page.");	
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Enter details on where do you live page
		bStatus = GapPageObject.whereDoYouLiveStep(objMap.get("ApartmentNumber"), objMap.get("StreetName"), objMap.get("Suburb"), objMap.get("City"), objMap.get("PostalCode"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in where do you live page", "Unable to enter the details.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in where do you live page", "Succesfully entered the details in where do you live page");	
		
		
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Enter details on Medical Aid page
		bStatus = GapPageObject.medicalAidDetails(objMap.get("MedicalAidProvider"), objMap.get("MedicalAidNumber"), objMap.get("MedicalAidPlan"), objMap.get("MedicalAidStartDate"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in medical cover page", "Unable to enter the details.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in medical cover page", "Succesfully entered the details in where do you live page");	
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Enter details on Payment details page
		bStatus = GapPageObject.paymentDetails(objMap.get("AccountNumber"), objMap.get("AccountType"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Added details on payment page", "Unable to add details on payment page" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Add details on payment page", "Added details on payment button");
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to " + Messages.errorMsg);
			return;
		}		
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Click on Terms and conditions check box on confirmation page
		GapPageObject.confirmationPage();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on Terms and conditions check box.", "Unable to click on the T and C checkbox.. due to " + Messages.errorMsg);
			return;
		}		
		Reporting.logResults("Pass", "Click on Terms and conditions check box.", "Clicked on TandC checkbox");
		
		//Click on Submit button
		GapPageObject.confirmationPage();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on Terms and conditions check box.", "Unable to click on the T and C checkbox.. due to " + Messages.errorMsg);
			return;
		}		
		Reporting.logResults("Pass", "Click on Terms and conditions check box.", "Clicked on TandC checkbox");
	}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporting.logResults("Fail", "Something happened with the testcase", "Failed");
		}
	}	
	}
		
	
	

