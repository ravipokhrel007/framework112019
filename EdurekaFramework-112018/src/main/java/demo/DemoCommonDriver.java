package demo;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;

public class DemoCommonDriver{

	public static void main(String[] args) {
		try {
			CommonDriver cmnDriver= new CommonDriver("chrome");
			//CommonDriver cmnDriver= new CommonDriver("firefox");
			
			ScreenshotControl screenshotControl = new ScreenshotControl (cmnDriver.getDriver());
			
			cmnDriver.setPageLoadTimeout(40);
			cmnDriver.setElementDetectionTimeout(20);
			
			cmnDriver.navigateToFirstUrl("http://qatechhub.com");
			
			String filename = System.getProperty("user.dir") + "/screenshots/testimg.jpeg";
			screenshotControl.captureAndSaveScreenshot(filename);
			
			System.out.println(cmnDriver.getTitle());

			cmnDriver.closeAllBrowser();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
