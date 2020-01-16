package com.npw.testscripts.gap;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.npw.lib.GapNavigation;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Browser;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Messages;
import com.om.framework.lib.Wait;
import com.om.framework.pageObjects.GapPageObject;
import com.om.framework.reporting.Reporting;

public class TC_001 extends BaseTest
{
	private static boolean bStatus;
	public static void submitApp() throws IOException, HeadlessException, AWTException, InterruptedException
	{	
		Reporting.Functionality = "GAP";
		Reporting.Testcasename = "GAP Positive Flow Test Case";
		//add a function to dynamically pick up the class name and add it as a test case name.				
		try
		{
			
		//Enter decision page details
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
		bStatus = GapPageObject.whereDoYouLiveStep("101", "water stone", "milnerton", "cape town", "7441");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in where do you live page", "Unable to enter the details.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in where do you live page", "Succesfully entered the details in where do you live page");	
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
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Enter details on Medical Aid page
		bStatus = GapPageObject.medicalAidDetails("Discovery", "0987565", "06452939", "11/12/1990");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Enter/Fill the details in medical cover page", "Unable to enter the details.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Enter/Fill the details in medical cover page", "Succesfully entered the details in where do you live page");	
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Enter details on Payment details page
		bStatus = GapPageObject.paymentDetails("0987877", "ravneet");
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Added details on payment page", "Unable to add details on payment page" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Add details on payment page", "Added details on payment button");
		bStatus = GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		GapPageObject.continueButton();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on CONTINUE button.", "Unable to click on the Continue button.. due to" + Messages.errorMsg);
			return;
		}		
		Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
		
		//Click on Terms and conditions check box on confirmation page
		GapPageObject.confirmationPage();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on Terms and conditions check box.", "Unable to click on the T and C checkbox.. due to" + Messages.errorMsg);
			return;
		}		
		Reporting.logResults("Pass", "Click on Terms and conditions check box.", "Clicked on TandC checkbox");
		
		//Click on Submit button
		GapPageObject.confirmationPage();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Click on Terms and conditions check box.", "Unable to click on the T and C checkbox.. due to" + Messages.errorMsg);
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
		
	
	

