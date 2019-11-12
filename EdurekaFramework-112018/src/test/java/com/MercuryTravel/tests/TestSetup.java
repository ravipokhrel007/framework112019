package com.MercuryTravel.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mercuryTravel.pages.FlightPage;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;

public class TestSetup {
	CommonDriver cmnDriver;
	
	HomePage homepage;
	FlightPage flightpage;
	
	private WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setup() throws Exception {
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.setPageLoadTimeout(40);
		cmnDriver.setElementDetectionTimeout(10);
		
		cmnDriver.navigateToFirstUrl("https://www.mercurytravels.co.in");
		
		driver = cmnDriver.getDriver();
		homepage = new HomePage(driver);
		flightpage = new FlightPage(driver);
		
	}
	
	@AfterClass(alwaysRun=true)
	public void cleanup() throws Exception {
		cmnDriver.closeAllBrowser();
	}
}
