package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.Driver;

public class CommonDriver  implements Driver{
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	private int pageLoadTimeout;
	private int elementDetectionTimeout;
	
	
	public CommonDriver(String browserType) throws Exception
	{
		
		pageLoadTimeout = 30;
		elementDetectionTimeout = 10;
		
		browserType = browserType.trim();
		
		if(browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/p2707746/Desktop/SeleniumTraning/DriverExecutables/chromedriver");
			driver = new ChromeDriver();
			
		} else if(browserType.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "/Users/p2707746/Desktop/SeleniumTraning/DriverExecutables/geckodriver");
			driver = new FirefoxDriver();
			
		} else {
			throw new Exception("Invalid Browser Type : "+browserType);
		}
		
		
	}
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		
		url = url.trim();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url);
		
		
	}
	
	//-----------------------------------------------------------------------------------------------------

	@Override
	public String getTitle() throws Exception {

		return driver.getTitle();
		
		
	}
	//-----------------------------------------------------------------------------------------------------

	@Override
	public String getCurrentUrl() throws Exception {
		
		return driver.getCurrentUrl();
	}
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public String getPageSource() throws Exception {

		return driver.getPageSource();
	}
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void navigateToUrl(String url) throws Exception {
		
		url=url.trim();
		driver.get(url);

	}
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void navigateForward() throws Exception {
		
		driver.navigate().forward();
		
	}
	//-----------------------------------------------------------------------------------------------------
	
	
	@Override
	public void navigateBackward() throws Exception {
		
		driver.navigate().back();
		
	}
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void refresh() throws Exception {
		
		driver.navigate().refresh();
		
	}
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void closeBrowser() throws Exception {
		
		driver.close();
		if(driver!=null) {
			driver.close();
		}
		
	}
	//-----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void closeAllBrowser() throws Exception {
		
		driver.quit();
		if(driver!=null) {
			driver.quit();
		
	}

	}}
