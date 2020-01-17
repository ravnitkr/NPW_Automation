package com.npw.lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.npw.locators.GapLocators;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Wait;

public class GapNavigation extends BaseTest
{
	//private static boolean bStatus;
	
	public static boolean continueButton(String gapContinueButton)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.continueButton(gapContinueButton)), 20));
		{
		return Elements.clickElement(By.xpath(GapLocators.NavigationMenu.continueButton(gapContinueButton)));	
		}
	}
	
	public static boolean clickUsingId(String id)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.clickUsingID(id)), 20));
		{
		return Elements.clickElement(By.xpath(GapLocators.NavigationMenu.clickUsingID(id)));	
		}
	}
	
	public static boolean textInputfield(String searchableText, String inputText)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.inputFieldElements(searchableText)), 10));
		{
		return Elements.enterText(By.xpath(GapLocators.NavigationMenu.inputFieldElements(searchableText)), inputText);
		}
	}
	public static boolean selectValueFromDropDown(String locator)
	{
		if(Wait.waitForElementClickability(By.xpath(locator), 10));
		{
		return Elements.clickElement(By.xpath(locator));
		}
	}
	public static String verifyText()
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.verifyTextOnEveryPage()), 10));
		{
		return Elements.getText(By.xpath(GapLocators.NavigationMenu.verifyTextOnEveryPage()));
		}
	}
	
//	public static String getDependentDetailsText(String Page)
//	{
//		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.verifyTextOnEveryPage(pageName)), 10));
//		{
//		return Elements.getText(By.xpath(GapLocators.NavigationMenu.verifyTextOnEveryPage(pageName)));
//		}
//	}
	public static boolean scrollToElement(String locator)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.inputFieldElements(locator)), 10));
		{
		return Elements.scrollToView(By.xpath(GapLocators.NavigationMenu.inputFieldElements(locator)));
		}
	}
	
	public static List<WebElement> getallValidationMessages()
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.getValidationMessages()), 10));
		{
		return Elements.getWebElements(By.xpath(GapLocators.NavigationMenu.getValidationMessages()));
		}
	}

}
