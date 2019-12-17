package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class ProfilePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page Objects / By Locators
	By emailID = By.id("username");

	// 2. page class constructor:
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

}
