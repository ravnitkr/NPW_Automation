package com.om.framework.pageObjects;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.npw.lib.GapNavigation;
import com.npw.locators.GapLocators;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Messages;
import com.om.framework.reporting.Reporting;

public class GapPageObject {
	private static boolean bStatus;
	
	
		//can have a parameter to skip the continue button action
		public static boolean greateDecisionStep(String firstName, String surName, String phoneNumber, String email) throws InterruptedException, HeadlessException, IOException, AWTException
		{	
			//enter first name
			bStatus= GapNavigation.textInputfield("First Name(s)", firstName);
			if(!bStatus) return bStatus;			
			//enter surname
			bStatus= GapNavigation.textInputfield("Surname", surName);
			if(!bStatus) return bStatus;			
			//enter contact number
			bStatus= GapNavigation.textInputfield("Cellphone Number", phoneNumber);
			if(!bStatus) return bStatus;			
			//enter email address
			bStatus= GapNavigation.textInputfield("Email Address", email);	
			if(!bStatus) return bStatus;
						
			return bStatus;
		}
	
		public static boolean continueButton() throws HeadlessException, IOException, AWTException
		{	
			String getText= GapNavigation.verifyText();
			if(getText.contains("Gap Cover Application"))
			{
			bStatus = GapNavigation.continueButton("Continue");
			}
			else
			{
				 Reporting.logResults("Fail", "Could not find the Text " , "Found the required text");
			}
			if(!bStatus) 
			{
			return bStatus;
			}
			return bStatus;
		}
	
		public static boolean getToKnowBetterStep(String label, String ValueToSelect, String Intials, String idNumber, String dob) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.dropDownParentElements(label));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.selectValueByText(ValueToSelect));	
			if(!bStatus) return bStatus;
			bStatus=  GapNavigation.textInputfield("Initials", Intials);	
			if(!bStatus) return bStatus;
			bStatus=  GapNavigation.scrollToElement("RSA ID Number");
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.textInputfield("RSA ID Number", idNumber);
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.textInputfield("dd/mm/yyyy", dob);
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
		public static boolean whereDoYouLiveStep(String suiteNo, String streetName, String suburbName, String city, String postalCode) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			//bStatus = GapNavigation.continueButton("Continue");
			//if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Apartment/Suite Name and Number", suiteNo);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Street Name", streetName);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Suburb", suburbName);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("City", city);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.scrollToElement("Postal Code");
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Postal Code", postalCode);
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
		public static boolean medicalAidDetails(String aidProvider, String aidNumber, String plan, String planendDate) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			bStatus= GapNavigation.textInputfield("Medical Aid Provider", aidProvider);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Medical Aid Number", aidNumber);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Medical Aid Plan", plan);
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("dd/mm/yyyy", planendDate);	
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
		public static boolean paymentDetails(String accountNumber, String accountHolderName) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.dropDownParentElements("Debit Order Date"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.selectValueByNumber("1"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.dropDownParentElements("Bank Name"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.selectValueByNumber("1"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.scrollToElement("Account Number");
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Account Number", accountNumber);
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.dropDownParentElements("Account Type"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(GapLocators.NavigationMenu.selectValueByNumber("1"));	
			return bStatus;
		}
	
		public static boolean confirmationPage() throws InterruptedException, HeadlessException, IOException, AWTException
		{
			bStatus = GapNavigation.clickUsingId("checkbox-1");
			return bStatus;		
		}
		
		public static boolean getAllValidationMessages(String pageName) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			try
			{
			List<WebElement> getAllValidations= GapNavigation.getallValidationMessages();
			String keyName;
			String keyValue;
			bStatus = false;		
			for(int i=0; i<getAllValidations.size(); i++)			
			{
				keyName = "Validation" + pageName + (i);
				keyValue = BaseTest.getPropValue(keyName);
				System.out.println("---kayvalue" + keyValue);
				Reporting.logResults("Pass", "Getting validation: " , "Got validation" + keyValue);				
				if(getAllValidations.get(i).getText().equals(keyValue))
                {
					  Reporting.logResults("Pass", "Comparing stored Validations with the actual ones: " , "VALIDATION - " + getAllValidations.get(i).getText() + " MATCHES WITH " + keyValue);					  
                	  bStatus = true;
	            }
				else
				{
					Reporting.logResults("Fail", "Comparing stored Validations with the actual ones: ", "Unable to get all validations on  great decision step due to" + Messages.appErrorMsg);				
					return false;
				}
			}
			}
			catch(Exception e)
			{
				bStatus = false;
				Messages.errorMsg = e.getMessage();
			}
			
			return bStatus;		
		
	
			}
}

