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

public class TC_006_KnowYouBetterPage_Validations_WithBlankTextFields extends BaseTest{

	
	private static boolean bStatus;
	private static String TestData_path_GAP = "TestData/TestData.xls";
	private static String sheetName = "GAP";
	private static String TestCaseName = "TC_006_KnowYouBetterPage_Validations_WithBlankTextFields";
	private static Map<String, String> objMap;

	@Test
	public static void getAllValidationsFromKNowYouBetterPage()
			throws IOException, HeadlessException, AWTException, InterruptedException {
		Reporting.Functionality = "GAP";
		Reporting.Testcasename = "Get validations from the Know YOU BETTER page when text fields are kept blank";

		// Get data from Excel sheet
		objMap = Utilities.readTestData((Utilities.getProjectPath() + TestData_path_GAP), sheetName, TestCaseName);
		try {
//			bStatus = NavigateTo.hoverAndClickHeaderMenu(objMap);
//			if (!bStatus) {
//				Reporting.logResults("Fail", "Navigate to the Medical gap cover page",
//						"Issue in hoverAndClickHeaderMenu method due to " + Messages.errorMsg);
//				return;
//			}
//			Reporting.logResults("Pass", "Navigate to the Medical gap cover page", "Navigated to medical cover page.");
//			
//			// Select Plan 
//			bStatus = GapPageObject.selectPlan(objMap);
//			if (!bStatus) {
//				Reporting.logResults("Fail", "Select Medical gap Plan",
//						"Issue in selectPlan method due to " + Messages.errorMsg);
//				return;
//			}
//			Reporting.logResults("Pass", "Select Medical gap Plan", "Selected medical gap plan.");
			Thread.sleep(1000);
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
			
			// Enter invalid details
			bStatus = GapPageObject.greateDecisionStep(objMap);
			if (!bStatus) {
				Reporting.logResults("Fail", "Enter invalid details on great decision step.",
						"Unable to add details  on great decision step due to" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Enter invalid details on great decision step.",
					"Added details  on great decision step");
			
			// Enter get to know better step details
			Thread.sleep(1000);
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
			bStatus = GapPageObject.getToKnowBetterStep(objMap);
			if (!bStatus) {
				Reporting.logResults("Fail", "Enter/Fill the details in get To know better page.",
						"Unable to enter the details.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Enter/Fill the details in get To know better page.",
					"Succesfully entered the details in get To know better page.");
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");
			
			// Get all validations
			bStatus = GapPageObject.getAllValidationMessages("KnowYouBetterBLANKPage");
			if (!bStatus) {
				Reporting.logResults("Fail", "Get all validations on great decision step.",
						"Unable to get all validations on Know you better step due to" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Get all validations on great decision step.",
					"All validations successfully matched on Know you better Step");
		} catch (Exception e) {
			e.printStackTrace();
			Reporting.logResults("Fail", "Something happened with the testcase", "Failed");
		}

	}
	
	
}
