package com.npw.lib.GAP;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.npw.locators.LocatorsGap;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Wait;

public class GapNavigation extends BaseTest
{
	//private static boolean bStatus;
	private static Map<String,String> objMap;
	
	public static boolean continueButton(String gapContinueButton)
	{
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.continueButton(gapContinueButton)), 20));
		{
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.continueButton(gapContinueButton)));	
		}
	}
	
	public static boolean clickUsingId(String id)
	{
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.clickUsingID(id)), 20));
		{
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.clickUsingID(id)));	
		}
	}
	
	public static boolean textInputfield(String searchableText, String inputText)
	{
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(searchableText)), 10));
		{
			return Elements.enterText(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(searchableText)), inputText);
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
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.verifyH4TextOnEveryPage()), 10));
		{
			return Elements.getText(By.xpath(LocatorsGap.NavigationMenu.verifyH4TextOnEveryPage()));
		}
	}
	
	public static String verifyMenuItemText(String menuItem)
	{
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.verifyMenuText(menuItem)), 20));
		{
			return Elements.getText(By.xpath(LocatorsGap.NavigationMenu.verifyMenuText(menuItem)));
		}
	}
	public static boolean scrollToElement(String locator)
	{
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(locator)), 10));
		{
			return Elements.scrollToView(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(locator)));
		}
	}
	
	public static List<WebElement> getallValidationMessages()
	{
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.getValidationMessages()), 10));
		{
			return Elements.getWebElements(By.xpath(LocatorsGap.NavigationMenu.getValidationMessages()));
		}
	}
	
	public static boolean selectPlan(Map<String,String> objMap)
	{
		
		if(Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.selectGapPlan(objMap.get("planLink"))), 10));
				{
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.selectGapPlan(objMap.get("planLink"))));
		}
		

	}
	

}
