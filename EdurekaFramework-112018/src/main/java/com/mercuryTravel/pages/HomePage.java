package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseOperation {
	
	@FindBy(linkText = "International Holidays")
	private WebElement internationalHolidayLink;
	
	@FindBy(linkText = "Indian Holidays")
	private WebElement indianHolidayLink;
	
	@FindBy(linkText = "Flights")
	private WebElement flightLink;
	
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;
	
	@FindBy(linkText = "Customer Login")
	private WebElement customerLogin;
	
	@FindBy(linkText = "User Login")
	private WebElement userLogin;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(linkText = "sign_user_email")
	private WebElement userEmailId;
	
	@FindBy(linkText = "sign_user_password")
	private WebElement userPassword;
	
	@FindBy(xpath= "//div[@id='modalLogin']//form[@class = 'form-signin']//button")
	private WebElement loginButton;
	
	@FindBy(partialLinkText = "Welcome")
	private WebElement welcomeText;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String sUserEmailId, String sUserPassword) throws Exception {
		mouseControl.moveToElement(customerLogin);
		elementControl.clickElement(userLogin);
		
		elementControl.setText(userEmailId, sUserEmailId);
		elementControl.setText(userPassword, sUserPassword);
		
		elementControl.clickElement(loginButton);
		
	}
	public String getWelcomeText() throws Exception {
		
		return elementControl.getText(welcomeText);
	}
		
}
