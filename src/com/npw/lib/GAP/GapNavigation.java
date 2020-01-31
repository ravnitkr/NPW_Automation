package com.npw.lib.GAP;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.npw.locators.LocatorsGap;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Verify;
import com.om.framework.lib.Wait;

public class GapNavigation extends BaseTest {
	private static boolean bStatus;
	private static Map<String, String> objMap;

	public static boolean continueButton(String gapContinueButton) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.continueButton(gapContinueButton)),
				20)) {
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.continueButton(gapContinueButton)));
		}
		return bStatus;
	}

	public static boolean clickUsingId(String id) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.clickUsingID(id)), 20)) {
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.clickUsingID(id)));
		}
		return bStatus;
	}

	public static boolean textInputfield(String searchableText, String inputText) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(searchableText)),
				20)) {
			return Elements.enterText(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(searchableText)),inputText);
		}
		return bStatus;
	}

	public static boolean selectValueFromDropDown(String locator) {
		if (Wait.waitForElementClickability(By.xpath(locator), 20)) {
			return Elements.clickElement(By.xpath(locator));
		}
		return bStatus;
	}

	public static String verifyText() {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.verifyH4TextOnEveryPage()), 20)) {
			return Elements.getText(By.xpath(LocatorsGap.NavigationMenu.verifyH4TextOnEveryPage()));
		}
		return null;
	}

	public static String verifyMenuItemText(String menuItem) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.verifyMenuText(menuItem)), 20)) {
			return Elements.getText(By.xpath(LocatorsGap.NavigationMenu.verifyMenuText(menuItem)));
		}
		return null;
	}

	public static boolean scrollToInputElement(String locator) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(locator)), 20)) {
			return Elements.scrollToView(By.xpath(LocatorsGap.NavigationMenu.inputFieldElements(locator)));
		}
		return bStatus;
	}

	public static List<WebElement> getallValidationMessages() {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.getValidationMessages()), 20)) {
			return Elements.getWebElements(By.xpath(LocatorsGap.NavigationMenu.getValidationMessages()));
		}
		return null;
	}

	public static boolean selectPlanTab(String planName) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.selectGapPlanTab(planName)), 20)) {
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.selectGapPlanTab(planName)));
		}
		return bStatus;
	}

	public static boolean selectSubHeader(String headerName) {
		if (Wait.waitForElementClickability(By.xpath(LocatorsGap.NavigationMenu.selectHeaderName(headerName)), 20)) {
			return Elements.clickElement(By.xpath(LocatorsGap.NavigationMenu.selectHeaderName(headerName)));
		}
		return bStatus;

	}

	public static boolean moveToElem(By objLocator) {
		bStatus = Verify.verifyElementPresent(objLocator);
		if (bStatus) {
			WebElement element = driver.findElement(objLocator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		}
		return bStatus;
	}

}
