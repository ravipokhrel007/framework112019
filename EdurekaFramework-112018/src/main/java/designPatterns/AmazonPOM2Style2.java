package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementsControl;

public class AmazonPOM2Style2 {
	
	private WebElement searchBox;
	
	private WebElement searchCategory;
	
	private WebElement searchButton;
	
	private ElementsControl elementControl;
	private DropdownControl dropdownControl;
	
	public AmazonPOM2Style2(WebDriver driver) {
		elementControl = new ElementsControl();
		dropdownControl = new DropdownControl();
		
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchCategory = driver.findElement(By.id("searchDropdownBox"));
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
	
	}
	
	public void searchProduct(String product, String category) throws Exception {
		
		elementControl.setText(searchBox, "Rado Watch");
		dropdownControl.selectViaVisibleText(searchCategory, "Watches");
		
		elementControl.clickElement(searchButton);
		
	}
		
}
