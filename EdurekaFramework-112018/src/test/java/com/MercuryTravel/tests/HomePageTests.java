package com.MercuryTravel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestSetup {

	@Test
	public void verifyLoginToApplication() throws Exception {
		
		String sUserEmailId = "saurabh.d2106@gmail.com";
		String sUserPassword	= "Pri@1234";
		homepage.userLogin(sUserEmailId, sUserPassword);
		
		String actualWelcomeText = "Welcome, Saurav";
		
		String expectedWelcomeText = homepage.getWelcomeText();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
	
	
	
	
	
	
}
