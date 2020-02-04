package demo;

import org.testng.annotations.Test;

//import com.mercuryTravel.utils.TestDataProvider;

import com.MercuryTravel.utils.TestDataProvider;


public class DemoTestDataProvider {
	
	@Test(dataProvider="getTestData", dataProviderClass=TestDataProvider.class)
	
	public void printTestData(String[] parameters) {
		for(String temp: parameters) {
			System.out.println(temp);
		}
	}

}
