package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementsControl;
import commonLibs.implementation.MouseControl;

public class BaseOperation {

	protected ElementsControl elementControl;
	protected DropdownControl dropdownControl;
	protected MouseControl mouseControl;
	
	
	public BaseOperation(WebDriver driver) {
		elementControl = new ElementsControl();
		dropdownControl = new DropdownControl();
		mouseControl = new MouseControl(driver);
	}
	
	
	
	
}
