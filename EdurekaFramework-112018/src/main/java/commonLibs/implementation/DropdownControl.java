package commonLibs.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.DropDown;

public class DropdownControl implements DropDown {

	private Select getDropDown(WebElement element) {
	Select select = new Select (element);
	return select;
	}
	
	
	@Override
	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {
		
		getDropDown(element).selectByVisibleText(visibleText);
		
	}
//-------------------------------------------------------------------
	
	
	@Override
	public void selectViaValue(WebElement element, String value) throws Exception {
		getDropDown(element).selectByValue(value);
		
	}
	//-------------------------------------------------------------------
	
	
	@Override
	public void selectViaIndex(WebElement element, int index) throws Exception {
		getDropDown(element).selectByIndex(index);
		
	}
	//-------------------------------------------------------------------
	
	
	@Override
	public boolean isMultiple(WebElement element) throws Exception {
		
		return getDropDown(element).isMultiple();
	}
	//-------------------------------------------------------------------
	
	
	@Override
	public List<WebElement> getAllOption(WebElement element) throws Exception {
	
		return getDropDown(element).getOptions();
	}
	//-------------------------------------------------------------------
	
	
	@Override
	public List<WebElement> getAllSelectedOption(WebElement element) throws Exception {
		
		return getDropDown(element).getAllSelectedOptions();
	}
	//-------------------------------------------------------------------
	
	
	@Override
	public WebElement getFirstSelectedOption(WebElement element) throws Exception {
		
		return getDropDown(element).getFirstSelectedOption();
	}

	
	
}
