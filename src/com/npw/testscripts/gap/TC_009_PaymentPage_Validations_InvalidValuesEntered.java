package com.npw.testscripts.gap;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.npw.lib.RA.NavigateTo;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.lib.Utilities;
import com.om.framework.pageObjects.GapPageObject;
import com.om.framework.reporting.Reporting;

public class TC_009_PaymentPage_Validations_InvalidValuesEntered extends BaseTest {

	private static boolean bStatus;
	private static String TestData_path_GAP = "TestData/TestData.xls";
	private static String sheetName = "GAP";
	private static String TestCaseName = "TC_009_PaymentPage_Validations_InvalidValuesEntered";
	private static Map<String, String> objMap;

	@Test
	public static void getAllValidationsFromGreatDecisionPage()
			throws IOException, HeadlessException, AWTException, InterruptedException {
		Reporting.Functionality = "GAP";
		Reporting.Testcasename = "Get all validations from the Payment detail page when Invalid values are entered";

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
			Reporting.logResults("Pass", "Click on CONTINUE button", "CLicked on Continue button");

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
						"Unable to click on the Continue button.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
			Thread.sleep(1000);
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
			Thread.sleep(1000);
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");

			// Enter details on where do you live page
			bStatus = GapPageObject.whereDoYouLiveStep(objMap);
			if (!bStatus) {
				Reporting.logResults("Fail", "Enter/Fill the details in where do you live page",
						"Unable to enter the details.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Enter/Fill the details in where do you live page",
					"Succesfully entered the details in where do you live page");
			Thread.sleep(1000);
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");
			Thread.sleep(1000);
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");

			// Enter details on Medical Aid page
			bStatus = GapPageObject.medicalAidDetails(objMap);
			if (!bStatus) {
				Reporting.logResults("Fail", "Enter/Fill the details in medical cover page",
						"Unable to enter the details.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Enter/Fill the details in medical cover page",
					"Succesfully entered the details in where do you live page");
			Thread.sleep(1000);
			bStatus = GapPageObject.continueButton();
			if (!bStatus) {
				Reporting.logResults("Fail", "Click on CONTINUE button.",
						"Unable to click on the Continue button.. due to " + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Click on CONTINUE button", "Clicked on Continue button");

			// Enter details on Payment details page
			bStatus = GapPageObject.paymentDetails(objMap);
			if (!bStatus) {
				Reporting.logResults("Fail", "Added details on payment page",
						"Unable to add details on payment page" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Add details on payment page", "Added details on payment button");

			// Get all validations
			bStatus = GapPageObject.getAllValidationMessages("PaymentDetailsPage");
			if (!bStatus) {
				Reporting.logResults("Fail", "Get all validations on Payment Details step.",
						"Unable to get all validations on  Payment Details Page due to" + Messages.errorMsg);
				return;
			}
			Reporting.logResults("Pass", "Get all validations on Payment Details step.",
					"All validations successfully matched on Payment Details Step");

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporting.logResults("Fail", "Something happened with the testcase", "Failed");
		}

	}
}
