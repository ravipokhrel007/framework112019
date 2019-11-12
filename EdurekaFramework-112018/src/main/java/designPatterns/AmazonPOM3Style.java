package designPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPOM3Style {

		@CacheLookup
		@FindBy (id="twotabsearchtextbox")
		private WebElement searchBox;
	
		@CacheLookup
		@FindBy (id="searchDropdownBox")	
		private WebElement searchCategory;
		
		@CacheLookup
		@FindBy (xpath="//input[@value='Go']")	
		private WebElement searchButton;
		
		
		@FindBy (xpath="//span[contains(text(),'results for')]")	
		private WebElement result;
		
		public AmazonPOM3Style(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
	
}
