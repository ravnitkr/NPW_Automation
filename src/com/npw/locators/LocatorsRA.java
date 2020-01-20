package com.npw.locators;

import org.openqa.selenium.By;

public class LocatorsRA 
{
	public static String sXpath = "";
	
	
	public static class NavigationMenu
	{
		public static String getHeaderMenu(String sAppMenuItem)
		{
			//sXpath = "//div[contains(@class,'container-desktop')]//a[@href='/"+sAppMenuItem+"' or text()='"+sAppMenuItem+"']";
			//sXpath="//div[@class='om-main-navigation-col-2 main-navigation-items-desktop']/om-main-navigation-menu/ul/li/a[@href='/"+sAppMenuItem+"']";
			sXpath="//div[contains(@class,'container-desktop')]//a[text()='"+sAppMenuItem +"']";
			//sXpath="//div[contains(@class,'container-desktop')]//li[@class='active']//a[text()='"+sAppMenuItem+"']";
			//div[contains(@class,'container-desktop')]//a[text()='Wealth']
			//div[contains(@class,'container-desktop')]//a[text()='personal']
			return sXpath;
		}
		
		public static String subHeaderHover(String sHoverMenu)
		{
			//sXpath="//div[contains(@class, 'desktop desktop-scroll-nav')]//a[@href=\"/personal/solutions\" and contains(text(), 'Our  ')]";
			sXpath="//div[contains(@class,'container-desktop')]//li[@class='active']//a[text()='"+sHoverMenu+"']";
			return sXpath;
		}
		
	}
	
	public static class RaApp
	{
		public static String selectRaPlan(String sRaPlaneName)
		{
			sXpath="//div[contains(@class,'comparison-table-desktop-container')]//a[contains(@href, '"+sRaPlaneName+"')]";
			//sXpath="//a[contains(@href, '"+sRaPlaneName+"')]";
			//div[contains(@class,'comparison-table-desktop-container')]//a[contains(@href, '/retirement-ann')] 
			return sXpath;
		}
			
		public static String btnContinue(String btnContinue)
		{
			sXpath="//*[text()='"+btnContinue+"']";
			return sXpath;
		}
		
		public static String btnBackToHome(String btnBackHome)
		{
			sXpath="//*[contains(text(), '"+btnBackHome+"')]";
			return sXpath;
		}
		
		
		public static String inputText(String Stext)
		{
			//sXpath= "//*[@placeholder='"+Stext+"']"; 
			//sXpath="//om-input-field[@preset='"+Stext+"' or @placeholder='"+Stext+"']//input[@class='om-input-field left validation-error-border' or @class='om-input-field om-input-field--completed left']";
			//sXpath="//om-input-field[contains(@preset, '"+Stext+"') or contains(@placeholder, '"+Stext+"')]//input[@class='om-input-field left validation-error-border' or @class='om-input-field om-input-field--completed left']";
			//sXpath="//om-input-field[contains(@preset, '"+Stext+"') or contains(@placeholder, '"+Stext+"')]//input[contains(@class, 'om-input-field left') or @class='om-input-field om-input-field--completed left']";
			//sXpath="//span[contains(text(),'"+Stext+"')]/../input[contains(@class, 'om-input')]";
			
			//input[((@type='text') and (preceding-sibling::span[text()='First Name(s)'] or @placeholder='First Name(s)')) or ancestor::om-input-field[contains(@preset,'First Name(s)') or contains(@placeholder,'First Name(s)')]]
			//sXpath="//om-input-field[contains(@preset,'"+Stext+"')  or contains(@placeholder,'"+Stext+"')]//input";
			sXpath="//input[((@type='text') and (preceding-sibling::span[text()='"+Stext+"'] or @placeholder='"+Stext+"')) or "
					+ "ancestor::om-input-field[contains(@preset,'"+Stext+"') or contains(@placeholder,'"+Stext+"')]]";
			
			return sXpath;
		}
		
		public static String clickDropDown(String sText)
		{
			//sXpath="//Select[@slot='"+sText+"']";
			//sXpath="//div[@class='om-dropdown-component']";
			//sXpath = "//div[@class='ez-personal-details']//select";
			//sXpath="//ul[@class='dropdown-options-list']//li[text()='"+sText+"']";
			sXpath="//select//option[contains(text(),'"+sText+"')]//..//..//div[@class='om-dropdown-field']";
			return sXpath;
		}

		public static String dropDown(String sText)
		{
			//sXpath="//Select[@slot='"+sText+"']";
			//sXpath="//div[@class='om-dropdown-component']";
			//sXpath = "//div[@class='ez-personal-details']//select";
			sXpath="//ul[@class='dropdown-options-list']//li[text()='"+sText+"']";
			return sXpath;
		}
		
		public static String subHeaderTitle(String sSubHeaderTtl)
		{
			//sXpath="//div[@class='om-investment-details']//h5[contains(text(), '"+sSubHeaderTtl+"')]";
			sXpath="//h5[contains(text(), '"+sSubHeaderTtl+"')]";
			return sXpath;
		}
		
		public static String subHeaderTitle2(String sSubHeaderTtl)
		{
			//sXpath="//div[@class='om-investment-details']//h5[contains(text(), '"+sSubHeaderTtl+"')]";
			sXpath="//strong[contains(text(),'"+sSubHeaderTtl+"')]";
			return sXpath;
		}
		
		public static String checkBoxInvestmentPage(String Stext)
		{
			//sXpath="//om-product-info-accordion[contains(@heading, '"+Stext+"')]//span[@class='om-checkbox-icon']";
			//sXpath="//om-product-info-accordion[contains(@heading, '"+Stext+"')]//input[@type='checkbox']";
			//sXpath="//om-product-info-accordion[contains(@heading, '"+Stext+"')]//label[@class='om-checkbox-container']";
			//sXpath="//h4[contains(text(),'"+Stext+"')]/ancestor::div[@class='product-info-accordion']//label[@class='om-checkbox-container']";
			sXpath="//h4[contains(text(),'"+Stext+"')]/ancestor::div[@class='product-info-accordion']//om-check-box";
			return sXpath;
		}
		
		public static String radioBtnInvestmentPage(String Stext)
		{
			//sXpath="//span[contains(text(),'Increase')]//..//input[@type='radio']";
			sXpath="//om-radio-button[contains(@radio-button-text,'"+Stext+"')]";
			return sXpath;
		}
		
		public static String enterSplitPercentage(String sText)
		{
			sXpath="//h6[@class='medium' and contains(text(),'"+sText+"')]//..//..//..//om-input-field[@suffix=\"%\"]//input[contains(@class,'om-input-field')]";
			return sXpath;
		}
		
		public static String dropDownPersonalDtls(String sFieldName, String sValue)
		{
			sXpath="//span[contains(text(),'"+sFieldName+"')]//..//ul[@class='dropdown-options-list']//li[text()='"+sValue+"']";
			return sXpath;
		}
		
		public static String checkBoxPaymentDetails(String Stext)
		{
			//sXpath="//om-product-info-accordion[contains(@heading, '"+Stext+"')]//span[@class='om-checkbox-icon']";
			//sXpath="//om-product-info-accordion[contains(@heading, '"+Stext+"')]//input[@type='checkbox']";
			//sXpath="//om-product-info-accordion[contains(@heading, '"+Stext+"')]//label[@class='om-checkbox-container']";
			//sXpath="//h4[contains(text(),'"+Stext+"')]/ancestor::div[@class='product-info-accordion']//label[@class='om-checkbox-container']";
			sXpath="//om-check-box[contains(@text,'"+Stext+"')]//span[@class='om-checkbox-icon']";
			return sXpath;
		}
		
		
	}
}
