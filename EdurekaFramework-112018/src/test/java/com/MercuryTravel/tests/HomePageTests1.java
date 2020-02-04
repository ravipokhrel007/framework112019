package com.MercuryTravel.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class HomePageTests1 extends TestSetup1 {
		
	
	@Parameters({"sUserEmailId1","sUserPassword1"})
	@Test
	public void verifyLoginToApplication(String sUserEmailId1, String sUserPassword1) throws Exception {
		

		extentReport.test = extentReport.extent.createTest("Tc - 121 - Verify Login to Mercury Travel with parameters : " + sUserEmailId1 + " " + sUserPassword1 );
		homepage1.userLogin(sUserEmailId1, sUserPassword1);
		
		String actualWelcomeText = "Welcome, Saurabh1";
		
		String expectedWelcomeText = homepage1.getWelcomeText();
		
		AssertJUnit.assertEquals(actualWelcomeText, expectedWelcomeText);
		
		extentReport.test.log(Status.INFO, "Both Actual and Welcome Text Matches");
	}
	

}
