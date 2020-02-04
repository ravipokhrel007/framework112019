 //Without Extent Report
 /*package com.MercuryTravel.tests;
 

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.internal.annotations.ITest;

import com.mercuryTravel.pages.FlightPage;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigReader;
import commonLibs.utils.DateUtils;

public class TestSetup1 {
	
	
	CommonDriver cmnDriver;
	
	
	HomePage homepage1;
	FlightPage flightpage1;
	
	public Properties configProperties;
	private WebDriver driver;
	public String currentProjectPath;
	public ScreenshotControl screenshotControl;
	
	@BeforeClass(alwaysRun=true)
	public void setup() throws Exception {
		
		setCurrentDirectoryPath();
		uploadConfigProperties();
		
				
		
		cmnDriver = new CommonDriver(configProperties.getProperty("browserType"));
		
		
		
		
		int pageLoadTimeout = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		
		cmnDriver.navigateToFirstUrl(configProperties.getProperty("baseUrl"));
		
		
		driver = cmnDriver.getDriver();
		
		initializeScreenshot();
		
		homepage1 = new HomePage(driver);
		flightpage1 = new FlightPage(driver);
		
	}

	private void setCurrentDirectoryPath() {
		currentProjectPath = System.getProperty("user.dir");
			}
	
	private void uploadConfigProperties() throws Exception {
		configProperties = ConfigReader.getProperties( currentProjectPath + "/config/config.properties");
			}
	
	private void initializeScreenshot() {
		screenshotControl = new ScreenshotControl(driver);
			}
	
	@AfterClass(alwaysRun=true)
	public void cleanup() throws Exception {
		cmnDriver.closeAllBrowser();
		
	}
	
	@AfterMethod
	public void afterAMethod(ITestResult result) throws Exception {
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String executionTime = DateUtils.getDate();
			String screenshotPath = String.format("%s/screenShots/%s_%s.jpeg", currentProjectPath,result.getName(),executionTime);
			screenshotControl.captureAndSaveScreenshot(screenshotPath);
			
		}
	
		
	}
}

*/
//WITH EXTENT REPORT

 package com.MercuryTravel.tests;
 

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.internal.annotations.ITest;

import com.MercuryTravel.common.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mercuryTravel.pages.FlightPage;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigReader;
import commonLibs.utils.DateUtils;

public class TestSetup1{
	
	
	CommonDriver cmnDriver;
	
	
	HomePage homepage1;
	FlightPage flightpage1;
	
	public Properties configProperties;
	private WebDriver driver;
	public String currentProjectPath;
	public ScreenshotControl screenshotControl;
	public ExtentReport extentReport;
	
	public String executionStartTime;
	
	@BeforeClass(alwaysRun=true)
	public void setup() throws Exception {
		
		
		executionStartTime = DateUtils.getDate();
		extentReport = new ExtentReport();
		
//			String reportFileName = String.format("%s / reports/MercuryTravelTest_%s.html", currentProjectPath, executionStartTime);

		String reportFileName = String.format("/Users/p2707746/git/framework112019/EdurekaFramework-112018/reports/MercuryTravelTest_%s.html", executionStartTime);

		extentReport.initializeReport(reportFileName);
		
		extentReport.test = extentReport.extent.createTest("Initialize Basic Setup");
	
		
		setCurrentDirectoryPath();
		uploadConfigProperties();
					
		
		cmnDriver = new CommonDriver(configProperties.getProperty("browserType"));
		
		
		
		
		int pageLoadTimeout = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		
		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		
		
		extentReport.test.log(Status.INFO,"Navigating to  Base URL");
		cmnDriver.navigateToFirstUrl(configProperties.getProperty("baseUrl"));
		
		
		driver = cmnDriver.getDriver();
		
		initializeScreenshot();
		
		homepage1 = new HomePage(driver);
		flightpage1 = new FlightPage(driver);
		
	}

	private void setCurrentDirectoryPath() {
		
		extentReport.test.log(Status.INFO,"Getting the Project working directory");
		currentProjectPath = System.getProperty("user.dir");
			}
	
	private void uploadConfigProperties() throws Exception {
		
		extentReport.test.log(Status.INFO,"Reading config files");
		configProperties = ConfigReader.getProperties( currentProjectPath + "/config/config.properties");
			}
	
	private void initializeScreenshot() {
		screenshotControl = new ScreenshotControl(driver);
			}
	
	
	
	@AfterClass(alwaysRun=true)
	public void cleanup() throws Exception {
		cmnDriver.closeAllBrowser();
		extentReport.flushReport();
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterAMethod(ITestResult result) throws Exception {
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String executionTime = DateUtils.getDate();
			String screenshotPath = String.format("%s/screenShots/%s_%s.jpeg", currentProjectPath,result.getName(),executionTime);
			
			String screenshotFile = screenshotControl.captureAndSaveScreenshot(screenshotPath);
			
			extentReport.test.addScreenCaptureFromPath(screenshotFile);
			
			
		}
	
		
	}
}
