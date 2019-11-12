package designPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementsControl;

public class AmazonPOM2Test {

	
	private CommonDriver cmnDriver;
	private WebDriver driver;
	private AmazonPOM2Style2 homePage;
	
	@BeforeClass
	
	public void initialize() throws Exception{
		
		cmnDriver = new CommonDriver("chrome");
		cmnDriver.setPageLoadTimeout(40);
		cmnDriver.setElementDetectionTimeout(10);
		
		cmnDriver.navigateToFirstUrl("https://www.amazon.in");
		
		driver = cmnDriver.getDriver();
		homePage  = new AmazonPOM2Style2(driver);
	}
	
	@AfterClass
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowser();
		
	}
	
	@Test
	
	public void searchProduct() throws Exception {
		homePage.searchProduct("Rado Watch", "Watches");
	}
	
}
