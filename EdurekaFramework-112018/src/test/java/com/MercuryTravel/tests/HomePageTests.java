package com.MercuryTravel.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestSetup {

	
	@Parameters({"sUserEmailId","sUserPassword"})
	@Test
	public void verifyLoginToApplication(String sUserEmailId, String sUserPassword ) throws Exception {
		
		extentReport.test = extentReport.extent.createTest("TC-001 - Verify Login to Mercury Travel with parameters: " + sUserEmailId + " " + sUserPassword);
		homepage.userLogin(sUserEmailId,  sUserPassword);

		String actualWelcomeText = "Welcome, Saurabh";
		
		String expectedWelcomeText = homepage.getWelcomeText();
		
		AssertJUnit.assertEquals(actualWelcomeText, expectedWelcomeText);
		
		extentReport.test.log(Status.INFO,  "Both Actual and Welcome text match");
	}
	
	
}
