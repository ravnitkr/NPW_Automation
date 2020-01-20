package com.om.framework.lib;

import java.io.File;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.om.framework.basetest.BaseTest;


public class Browser extends BaseTest
{
	private static Logger logger=Logger.getLogger("Browser");
	private static WebDriver wDriver;
	private static String sPathOfDriver;

	/**
	 * Performs a driver.get() to load the given URL on the current browser.
	 * 
	 * @param sURL	web URL to load 
	 * @author akosaraju
	 */
	public static void getURL(String sURL)
	{
		driver.get(sURL);
	}
	public static WebDriver openBrowser(String sURL)
	{
		if(wDriver==null)
		{
			try{
				wDriver = new FirefoxDriver();
				logger.info("Firefox browser is opened successfully");
				wDriver.get(sURL);
				wDriver.manage().window().maximize();	
			}
			catch(Exception e)
			{
				Messages.errorMsg = e.getMessage();
				logger.warn(Messages.errorMsg);
			}
		}
		return wDriver;
	}

	public static WebDriver openBrowser(String sBrowserName,String sURL,String sPathOfDriver)
	{
		if(sBrowserName.equalsIgnoreCase("ie")){
			logger.info("The application has been invoked successfully in Internet Explorer with URL:"+sURL);
			return openIEBrowser(sURL, sPathOfDriver);
		}
		else if(sBrowserName.equalsIgnoreCase("edge")){
			logger.info("The application has been invoked successfully in Edge with URL:"+sURL);
			return openEdgeBrowser(sURL, sPathOfDriver);
		}
		else if(sBrowserName.equalsIgnoreCase("chrome")){
			logger.info("The application has been invoked successfully in Google Chrome with URL:"+sURL);
			return openChromeBrowser(sURL, sPathOfDriver);
		}
		else if((sBrowserName.equalsIgnoreCase("ff") || sBrowserName.equalsIgnoreCase("firefox")) && sPathOfDriver.length()>0)
		{
			logger.info("The application has been invoked successfully in Firefox with URL:"+sURL);
			return openFirefoxBrowser(sURL, sPathOfDriver);
		}
		else if(sBrowserName.equalsIgnoreCase("ff") || sBrowserName.equalsIgnoreCase("firefox")){
			
			logger.info("The application has been invoked successfully in Firefox with URL:"+sURL);
			return openBrowser(sURL);
		}
		else {
			Messages.errorMsg="No browser drivers found";
			logger.warn("The application could not be invoked due to "+Messages.errorMsg);
			return wDriver;
		}			
		
	}
	
//	public static String getDriverPath() {
//	      String OS = System.getProperty("os.name");
//
//	        if (OS.contains("Window")) {
//	            return "libs/chromedriver_win"
//	        } else if (OS.contains("Mac")) {
//	            return "libs/chromedriver_mac"
//	        } else {
//	            return "libs/chromedriver_linux"
//	        }
//	         
//	}

	private static WebDriver openFirefoxBrowser(String sURL, String sPathOfDriver)
	{	
		if(wDriver==null)
		{
			try{
				System.setProperty("webdriver.gecko.driver", sPathOfDriver);
				wDriver = new FirefoxDriver();
				logger.info("Firefox browser is opened successfully");
				wDriver.get(sURL);
				wDriver.manage().window().maximize();	
			}
			catch(Exception e)
			{
				Messages.errorMsg = e.getMessage();
				logger.warn(Messages.errorMsg);
			}
		}
		return wDriver;
	}


	/**
	 * Opens a new chrome browser instance to given URL.
	 * Usage: driver = openChromeBrowser(url,pathofdriver)
	 * 
	 * @param sURL	web URL to load
	 * @param sPathOfDriver	path under project workspace where the browser .exe is located
	 * @return WebDriver
	 * @author akosaraju
	 */
	private static WebDriver openChromeBrowser(String sURL, String sPathOfDriver )
	{

		try{
			System.setProperty("webdriver.chrome.driver",sPathOfDriver);
			wDriver = new ChromeDriver();	
			logger.info("Chrome browser is opened successfully");
			System.out.println("Chrome browser is opened successfully");
			wDriver.get(sURL);
			wDriver.manage().window().maximize();	
		}
		catch(Exception e)
		{
			Messages.errorMsg = e.getMessage();
			logger.warn(Messages.errorMsg);
		}

		return wDriver;
	}

	/**
	 * Opens a new chrome browser and extension instance to given URL.
	 * Usage: driver = openChromeBrowser(sURL, sDriverPath, sExtensionPath)
	 * 
	 * @param sURL	web URL to load
	 * @param sPathOfDriver	path under project workspace where the browser .exe is located
	 * @param sExtensionPath path under project workspace where the extension is located
	 * @return WebDriver
	 * @author akosaraju
	 */
	public static WebDriver openChromeBrowserWithXtension(String sURL,String sPathOfDriver, String sExtensionPath)
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", sPathOfDriver);
			ChromeOptions options = new ChromeOptions();

			options.addExtensions(new File(sExtensionPath));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			wDriver = new ChromeDriver(capabilities);
			
			logger.info("Chrome browser with extension is opened successfully");
			System.out.println("Chrome browser with extension is opened successfully");

			wDriver.get(sURL);
			wDriver.manage().window().maximize();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Messages.errorMsg = e.toString();
			return null;
		}
		
		return wDriver;
	}
	
	/**
	 * Opens a new IE browser instance to given URL.
	 * Usage: driver = openIEBrowser(sURL, pathofdriver)
	 * 
	 * @param sURL	web URL to load
	 * @param sPathOfDriver	path under project workspace where the browser .exe is located
	 * @return WebDriver
	 * @author akosaraju
	 */
	//@SuppressWarnings("deprecation")
	private static WebDriver openIEBrowser(String sURL, String sPathOfdriver)
	{
		try{
			System.setProperty("webdriver.ie.driver",sPathOfdriver);
			//DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			//dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//dc.setCapability("nativeEvents", false);
			//wDriver = new InternetExplorerDriver(dc);
			wDriver = new InternetExplorerDriver();
			logger.info("IE browser is opened successfully");
			wDriver.manage().deleteAllCookies();
			wDriver.get(sURL);
			wDriver.manage().window().maximize();
			
			//handle any test site security certificate errors on IE
			try {
				driver = wDriver;
				String moreInformationLink = "More information";
				if (Wait.waitForElementVisibility(By.linkText(moreInformationLink), 1)) {
					Elements.clickElement(By.linkText(moreInformationLink));
					String overrideLinkID = "overridelink";
					Elements.clickElement(By.id(overrideLinkID));
				}
			}
			catch (Exception e) {
				//do nothing
			}						
		}
		catch(Exception e)
		{
			Messages.errorMsg = e.getMessage();
			logger.warn(Messages.errorMsg);
		}
		return wDriver;
	}
	
	/**
	 * Opens a new Edge browser instance to given URL.
	 * Usage: driver = openEdgeBrowser(sURL, pathofdriver)
	 * 
	 * @param sURL	web URL to load
	 * @param sPathOfDriver	path under project workspace where the browser .exe is located
	 * @return WebDriver
	 * @author akosaraju
	 */
	private static WebDriver openEdgeBrowser(String sURL, String sPathOfdriver)
	{
		try{
			System.setProperty("webdriver.edge.driver",sPathOfdriver);
			//DesiredCapabilities dc = DesiredCapabilities.edge();
			//dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//dc.setCapability("nativeEvents", false);
			wDriver = new EdgeDriver();
			logger.info("Edge browser is opened successfully");
			wDriver.manage().deleteAllCookies();
			wDriver.get(sURL);
			wDriver.manage().window().maximize();
			
			//handle any test site security certificate errors on Edge
			try {
				driver = wDriver;
				String detailsLinkID = "moreInformationDropdownSpan";
				if (Wait.waitForElementVisibility(By.id(detailsLinkID), 1)) {
					Elements.clickElement(By.id(detailsLinkID));
					String invalidCertContinueID = "invalidcert_continue";
					Elements.clickElement(By.id(invalidCertContinueID));
				}
			}
			catch (Exception e) {
				//do nothing
			}			
		}
		catch(Exception e)
		{
			Messages.errorMsg = e.getMessage();
			logger.warn(Messages.errorMsg);
		}
		return wDriver;
	}

	/**
	 * Close all the browsers related to given driver instance.
	 * 
	 * @param wDriver	WebDriver object
	 * @return boolean
	 * @author akosaraju
	 */
	public static boolean closeAllBrowsers(WebDriver wDriver)
	{
		try{
			if(wDriver != null)
			{
				wDriver.quit();	
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
				Runtime.getRuntime().exec("taskkill /T /F /IM geckodriver.exe");
				logger.info("Closed all open browsers and killing the driver instances successfully");
				return true;
			}
			logger.warn("The browsers could not be closed");
			return false;

		}
		catch(Exception e){
			Messages.errorMsg = e.getMessage();
			logger.warn("The browsers could not be closed because "+Messages.errorMsg);
			return false;
		}
	}

	/**
	 * Close the current browser related to given driver instance.
	 * 
	 * @param wDriver	WebDriver object
	 * @return boolean
	 * @author akosaraju
	 */
	public static boolean closeCurrentBrowser(WebDriver wDriver)
	{
		try{
			if(wDriver != null)
			{
				String sFocusedWindow = wDriver.getWindowHandle();
				Set<String> windows = wDriver.getWindowHandles();
				int iSize = windows.size();
				if(iSize > 1)
				{
					wDriver.close();
					for (String handle : windows) 
					{
						if(!sFocusedWindow.equalsIgnoreCase(handle))
						{
							wDriver.switchTo().window(handle);
						}
					}
				}	
				wDriver.close();
				logger.info("The current browser has been closed successfully");
				Runtime.getRuntime().exec("taskkill /T /F /IM chromedriver.exe");
				Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
				Runtime.getRuntime().exec("taskkill /T /F /IM geckodriver.exe");
				return true;
			}
			logger.warn("The current browser could not be closed");
			return false;

		}
		catch(Exception e){
			Messages.errorMsg = e.getMessage();
			logger.warn("The current browser could not be closed due to "+Messages.errorMsg);
			return false;
		}
	}

	/**
	 * Navigate back from the current page.
	 * 
	 * @param wDriver	WebDriver object
	 * @author akosaraju
	 */
	public static void navigateBack(WebDriver wDriver)
	{
		wDriver.navigate().back();
		logger.info("Successfully navigated back to previous web page");
	}

	/**
	 * Navigate forward from the current page.
	 * 
	 * @param wDriver	WebDriver object
	 * @author akosaraju
	 */
	public static void navigateForward(WebDriver wDriver)
	{
		wDriver.navigate().forward();
		logger.info("Successfully navigated forward to next web page");
	}

	/**
	 * Refresh the current page of the given wDriver.
	 * 
	 * @param wDriver	WebDriver object
	 * @author akosaraju
	 */
	public static void reloadPage(WebDriver wDriver)
	{
		wDriver.navigate().refresh();
		logger.info("The web page has been refreshed");
	}

	/**
	 * Delete all the cookies from the given wDriver.
	 * 
	 * @param wDriver	WebDriver object
	 * @author akosaraju
	 */
	public static void deleteAllCookies(WebDriver wDriver)
	{
		wDriver.manage().deleteAllCookies();
		logger.info("Successfully deleted all the browser cookies");
	}

	/**
	 * Delete the given cookie name from the given wDriver.
	 * @param wDriver	WebDriver object
	 * @param sCookieName	cookie name
	 * @author akosaraju
	 */
	public static void deleteCookie(WebDriver wDriver, String sCookieName)
	{
		wDriver.manage().deleteCookieNamed(sCookieName);
		logger.info("Successfully deleted the browser cookie"+sCookieName);
	}
	
	/**
	 * Returns the URL of the current browser page.
	 * 
	 * @return String
	 * @author akosaraju
	 */
	public static String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
}
