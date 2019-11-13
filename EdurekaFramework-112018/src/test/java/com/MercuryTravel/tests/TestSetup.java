package com.MercuryTravel.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mercuryTravel.pages.FlightPage;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigReader;

public class TestSetup {
	CommonDriver cmnDriver;
	
	HomePage homepage;
	FlightPage flightpage;
	
	public Properties configProperty;
	
	public String currentProjectPath;
	private WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setup() throws Exception {
		currentProjectPath = System.getProperty("user .dir");
		configProperty = ConfigReader.getProperties(currentProjectPath+"/config/config.properties");
		
		cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));

		int pageLoadTimeout =Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		int elementDetectionTimeout =Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
		
		
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		
		cmnDriver.navigateToFirstUrl("baseUrl");
		
		driver = cmnDriver.getDriver();
		homepage = new HomePage(driver);
		flightpage = new FlightPage(driver);
		
	}
	
	@AfterClass(alwaysRun=true)
	public void cleanup() throws Exception {
		cmnDriver.closeAllBrowser();
	}
}
