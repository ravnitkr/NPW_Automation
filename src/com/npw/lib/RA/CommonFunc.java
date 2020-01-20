package com.npw.lib.RA;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.npw.locators.LocatorsRA;
import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Messages;
import com.om.framework.lib.Wait;

public class CommonFunc 
{
	private static boolean bStatus;

	public static boolean selectDropDown(String stext)
	{
		//enter investment duration
		//click on the drop down for investment duration
		bStatus = Elements.clickElement(By.xpath(LocatorsRA.RaApp.clickDropDown(stext)));
		//bStatus=Elements.selectOptionByValue(By.xpath(Locators.RaApp.dropDown("select")), "Doctor");
		if(!bStatus) return bStatus;
		//Select drop down value for investment duration
		bStatus =  Elements.clickElement(By.xpath(LocatorsRA.RaApp.dropDown(stext)));
		if(!bStatus) return bStatus;

		return bStatus;
	}

	public static boolean selectDropDownPersonalDtls(String sFieldName,String sValue)
	{
		//enter investment duration
		//click on the drop down for investment duration
		bStatus = Elements.clickElement(By.xpath("//span[contains(text(),'"+sFieldName+"')]//..//div[@class='om-dropdown-field']"));
		//bStatus=Elements.selectOptionByValue(By.xpath(Locators.RaApp.dropDown("select")), "Doctor");
		if(!bStatus) return bStatus;
		//Select drop down value for investment duration
		bStatus =  Elements.clickElement(By.xpath(LocatorsRA.RaApp.dropDownPersonalDtls(sFieldName, sValue)));
		if(!bStatus) return bStatus;

		return bStatus;
	}


	public static boolean scrollToViewElement(By objLocator) throws InterruptedException
	{
		try
		{


			WebElement element = BaseTest.driver.findElement(objLocator);
			((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			return true;
		}

		catch(Exception e)
		{
			Messages.errorMsg= e.getMessage();
			return false;	
		}

	}

	public static boolean enterTextForSplitPercentage(By objLocator,String sValue) throws InterruptedException
	{
		bStatus = Wait.waitForElementVisibility(objLocator, 25);
		if(bStatus)
		{
			CommonFunc.scrollToViewElement(objLocator);
			BaseTest.driver.findElement(objLocator).click();
			//driver.findElement(objLocator).clear();
			BaseTest.driver.findElement(objLocator).sendKeys(sValue);
			System.out.println("The text "+sValue+" has been inputted successfully.");
			return true;
		}
		System.out.println("The text "+sValue+" could not be entered successfully");
		return false;	
	}

	public static boolean selectPlan(Map<String,String> objSelectPlan)
	{
		//Select plan and click 
		bStatus=Elements.clickElement(By.xpath(LocatorsRA.RaApp.selectRaPlan(objSelectPlan.get("selectRaPlan"))));//("retirement-annuity/starter")));
		if(!bStatus) return bStatus;

		//click continue to reach app 
		bStatus=Elements.clickElement(By.xpath(LocatorsRA.RaApp.btnContinue("Continue")));
		return bStatus;
	}

}
