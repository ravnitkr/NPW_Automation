package com.npw.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.om.framework.basetest.BaseTest;
import com.om.framework.lib.Elements;
import com.om.framework.lib.Windows;

public class TC_01_Demo extends BaseTest
{
	public static boolean bStatus;
	public static String sHomePageTitle = "";
	
	@Test
	public static void testSomething() throws IOException
	{
		
		String url;
		HttpURLConnection huc = null;
		int respCode = 200;
		String homePage = "https://new-public-web-qa.nonprod.digitalplatform.oldmutual.co.za/";
		//get list of all links
		 List<WebElement> allLinks = Elements.getWebElements(By.tagName("a"));
		  
		 sHomePageTitle = Windows.getWindowTitle();
		 
		
		 Iterator<WebElement> it = allLinks.iterator();
	        
	        while(it.hasNext()){
	            
	            url = it.next().getAttribute("href");
	            
	            System.out.println(url);
	            if(url == null || url.isEmpty()){
	            	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	            
	            if(!url.startsWith(homePage)){
	                System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }
	            
	            try {
	                huc = (HttpURLConnection)(new URL(url).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } 
	        }
	        
		 
		 
		
		System.out.println("Testing something");
		
	}

}
