package com.om.framework.pageObjects;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.npw.lib.GAP.GapNavigation;
import com.npw.locators.LocatorsGap;
import com.npw.locators.LocatorsRA;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Messages;
import com.om.framework.reporting.Reporting;

public class GapPageObject {
	private static boolean bStatus;
	private static Map<String,String> objMap;
	
	
		//can have a parameter to skip the continue button action
		public static boolean greateDecisionStep(Map<String, String> objMap) throws InterruptedException, HeadlessException, IOException, AWTException
		{	
			//enter first name
			bStatus= GapNavigation.textInputfield("First Name(s)", objMap.get("FirstName"));
			if(!bStatus) return bStatus;			
			//enter surname
			bStatus= GapNavigation.textInputfield("Surname", objMap.get("Surname"));
			if(!bStatus) return bStatus;			
			//enter contact number
			bStatus= GapNavigation.textInputfield("Cellphone Number", objMap.get("Cellphone"));
			if(!bStatus) return bStatus;			
			//enter email address
			bStatus= GapNavigation.textInputfield("Email Address", objMap.get("Email"));	
			if(!bStatus) return bStatus;
						
			return bStatus;
		}
		
		
	//Common function to click on CONTINUE button
		public static boolean continueButton() throws HeadlessException, IOException, AWTException
		{	
			String getText= GapNavigation.verifyText();
			if(getText.contains("Gap Cover Application"))
			{
			bStatus = GapNavigation.continueButton("Continue");
			Reporting.logResults("Pass", "Finding text" , "Found the required text");
			}
			else
			{
				 Reporting.logResults("Fail", "Finding text" , "Found the required text");
			}
			if(!bStatus) 
			return bStatus;
			return bStatus;
		}
		
		public static boolean verifyMenutext() throws HeadlessException, IOException, AWTException
		{	
			String getText= GapNavigation.verifyMenuItemText("Health");
			if(!(getText==("Health")))
				return bStatus;
			return bStatus;
		}
	
		public static boolean getToKnowBetterStep(Map<String, String> objMap) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.dropDownParentElements(objMap.get("Title")));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.selectValueByText(objMap.get("TitleValue")));	
			if(!bStatus) return bStatus;
			bStatus=  GapNavigation.textInputfield("Initials", objMap.get("Initials"));	
			if(!bStatus) return bStatus;
			bStatus=  GapNavigation.scrollToElement("RSA ID Number");
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.textInputfield("RSA ID Number", objMap.get("RSAID"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.textInputfield("dd/mm/yyyy", objMap.get("DOB"));
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
		public static boolean whereDoYouLiveStep(Map<String, String> objMap) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			//bStatus = GapNavigation.continueButton("Continue");
			//if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Apartment/Suite Name and Number", objMap.get("ApartmentNumber"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Street Name", objMap.get("StreetName"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Suburb", objMap.get("Suburb"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("City", objMap.get("City"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.scrollToElement("Postal Code");
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Postal Code", objMap.get("PostalCode"));
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
		public static boolean medicalAidDetails(Map<String, String> objMap) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			bStatus= GapNavigation.textInputfield("Medical Aid Provider", objMap.get("MedicalAidProvider"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Medical Aid Number", objMap.get("MedicalAidNumber"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Medical Aid Plan", objMap.get("MedicalAidPlan"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("dd/mm/yyyy", objMap.get("MedicalAidStartDate"));	
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
		public static boolean paymentDetails(Map<String, String> objMap) throws InterruptedException, HeadlessException, IOException, AWTException
		{
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.dropDownParentElements("Debit Order Date"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.selectValueByNumber("1"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.dropDownParentElements("Bank Name"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.selectValueByNumber("1"));
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.scrollToElement("Account Number");
			if(!bStatus) return bStatus;
			bStatus= GapNavigation.textInputfield("Account Number", objMap.get("AccountNumber"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.dropDownParentElements("Account Type"));
			if(!bStatus) return bStatus;
			bStatus = GapNavigation.selectValueFromDropDown(LocatorsGap.NavigationMenu.selectValueByNumber("1"));	
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
		
		public static boolean selectPlan(Map<String,String> objMap)
		{
			//Select GAP plan  
			bStatus=GapNavigation.selectPlan(objMap);
			if(!bStatus) return bStatus;
			return bStatus;
		}
		
}

