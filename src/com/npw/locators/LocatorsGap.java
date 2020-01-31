package com.npw.locators;

public class LocatorsGap 
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
		
		public static String verifyH4TextOnEveryPage()
		{
			sXpath = "//h4";
			return sXpath;
		}
		
		public static String verifyMenuText(String hovertext)
		{
			sXpath = "//div[contains(@class,'container-desktop')]//li[@class='active']//a[text()='"+hovertext+"']";
			return sXpath;
		}

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
		public static String selectGapPlanTab(String planName)
		{
			//sXpath = "//div[contains(@class, 'tabs-container')]//*[text()='"+planName+"']";
			sXpath = "//*[text()='"+planName+"']//ancestor::div[@class='om-product-card-container']//*[text()='BUY NOW']";
			return sXpath;
		}
		public static String selectHeaderName(String headerName)
		{
			sXpath="//div[contains(@class,'container-desktop')]//a[text()='"+headerName +"']";
			return sXpath;
		}
		
	}
}
