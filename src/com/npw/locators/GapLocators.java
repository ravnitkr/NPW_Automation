package com.npw.locators;

public class GapLocators 
{
	public static String sXpath = "";
	
	
	public static class NavigationMenu
	{
		public static String getAppMenuItemElement(String sAppMenuItem)
		{
			sXpath = "//div[contains(@class,'container-desktop')]//a[@href='/"+sAppMenuItem+"' or text()='"+sAppMenuItem+"']";
			return sXpath;
		}	
			
		public static String continueButton(String buttonText)
		{
			sXpath = "//span[contains(@class,'om-button-text') and text()='"+buttonText+"']";
			return sXpath;
		}
		
		public static String clickUsingID(String id)
		{
			sXpath = "//*[@id='"+id+"']";
			return sXpath;
		}
		
		public static String clickUsingButtonText(String buttonText)
		{
			sXpath = "//*[text()='"+buttonText+"']";
			return sXpath;
		}
		
		public static String inputFieldElements(String searchableText)
		{
			sXpath = "//input[contains(@placeholder, '"+searchableText+"')]";
			return sXpath;
		}
		
		public static String getValidationMessages()
		{
			sXpath = "//span[@class='validation-error-text']";
			return sXpath;
		}	
		
		public static String dropDownParentElements(String labelName)
		{			
			sXpath = "//om-dropdown-field[@label='"+labelName+"']"; 
			return sXpath;
		}
		
		public static String selectValueByText(String value)
		{		
			sXpath = "//ul[@class='dropdown-options-list']//li[text()='"+value+"']";
			return sXpath;
		}
		
		public static String selectValueByNumber(String number)
		{		
			sXpath = "//ul[@class='dropdown-options-list']//li['"+number+"']";
			return sXpath;
		}
		
//		public static String verifyTextOnEachPageBeforeEnteringText()
//		{		
//			sXpath = "//span[@class='om-label']";
//			return sXpath;
//		}
		
		public static String verifyTextOnEveryPage()
		{
			sXpath = "//h4";
			return sXpath;
		}
//		public static String verifyDependentDetailsText()
//		{
//			sXpath = "//div[contains(@class, 'gap-dependent-details')]//h4";
//			return sXpath;
//		}
		public static String startCover()
		{
			sXpath = "//span[contains(@class, 'om-icon-container')]";
			return sXpath;
		}
		public static String postalCode()
		{
			sXpath = "//span[contains(@class, 'om-icon-container')]";
			return sXpath;
		}
		
	}
}
