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
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.continueButton(gapContinueButton)), 20000));
		{
		return Elements.clickElement(By.xpath(GapLocators.NavigationMenu.continueButton(gapContinueButton)));	
		}
	}
	
	public static boolean clickUsingId(String id)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.clickUsingID(id)), 20000));
		{
		return Elements.clickElement(By.xpath(GapLocators.NavigationMenu.clickUsingID(id)));	
		}
	}
	
	public static boolean textInputfield(String searchableText, String inputText)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.inputFieldElements(searchableText)), 10000));
		{
		return Elements.enterText(By.xpath(GapLocators.NavigationMenu.inputFieldElements(searchableText)), inputText);
		}
	}
	public static boolean selectValueFromDropDown(String locator)
	{
		if(Wait.waitForElementClickability(By.xpath(locator), 10000));
		{
		return Elements.clickElement(By.xpath(locator));
		}
	}
	public static String getCoverText()
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.gapCoverText()), 10000));
		{
		return Elements.getText(By.xpath(GapLocators.NavigationMenu.gapCoverText()));
		}
	}
	
	public static String verifyText()
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.verifyTextOnEachPageBeforeEnteringText()), 10000));
		{
		return Elements.getText(By.xpath(GapLocators.NavigationMenu.verifyTextOnEachPageBeforeEnteringText()));
		}
	}
	public static boolean scrollToElement(String locator)
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.inputFieldElements(locator)), 10000));
		{
		return Elements.scrollToView(By.xpath(GapLocators.NavigationMenu.inputFieldElements(locator)));
		}
	}
	
	public static List<WebElement> getallValidationMessages()
	{
		if(Wait.waitForElementClickability(By.xpath(GapLocators.NavigationMenu.getValidationMessages()), 10000));
		{
		return Elements.getWebElements(By.xpath(GapLocators.NavigationMenu.getValidationMessages()));
		}
	}

}
