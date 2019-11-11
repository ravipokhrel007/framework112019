package designPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementsControl;


public class AmazonPOM1Test {
	
	
	private CommonDriver cmnDriver;
	private ElementsControl elementControl;
	private DropdownControl dropdownControl;
	private WebDriver driver;
	private AmazonPOM1Style homePage;
	
	
	

	@BeforeClass
	
	public void initialize() throws Exception{
		
		cmnDriver = new CommonDriver("chrome");
		cmnDriver.setPageLoadTimeout(40);
		cmnDriver.setElementDetectionTimeout(10);
		
		cmnDriver.navigateToFirstUrl("https://www.amazon.in");
		
		driver = cmnDriver.getDriver();
		
		elementControl = new ElementsControl();
		dropdownControl = new DropdownControl();
		
		homePage = new AmazonPOM1Style(driver);
		
	}
	
	@AfterClass
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowser();
		
	}
	
	@Test
	public void searchProduct() throws Exception {
		elementControl.setText(homePage.searchBox, "Rado Watch");
		dropdownControl.selectViaVisibleText(homePage.searchCategory, "Watches");
		
		elementControl.clickElement(homePage.searchButton);
		
	}
	
	
	
}
