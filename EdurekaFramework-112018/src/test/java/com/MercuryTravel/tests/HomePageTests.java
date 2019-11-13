package com.MercuryTravel.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestSetup {

	
	@Parameters({"sUserEmailId","sUserPassword"})
	@Test
	public void verifyLoginToApplication(String sUserEmailId, String sUserPassword ) throws Exception {
		

		homepage.userLogin(sUserEmailId, sUserPassword);
		
		String actualWelcomeText = "Welcome, Saurav";
		
		String expectedWelcomeText = homepage.getWelcomeText();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
	
	
	
	
	
	
}
