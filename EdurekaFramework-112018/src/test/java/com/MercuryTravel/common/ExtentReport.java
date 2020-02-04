package com.MercuryTravel.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.utils.DateUtils;

public class ExtentReport {
	
	public ExtentHtmlReporter htmlReporter1;
	public ExtentReports extent;
	public ExtentTest test;

	
	public void initializeReport(String reportFileName) {
		
		htmlReporter1 = new ExtentHtmlReporter(reportFileName);
		extent = new ExtentReports();
	
		extent.attachReporter(htmlReporter1);
	
	}

	
	public void flushReport() {
		extent.flush();
	}
}
