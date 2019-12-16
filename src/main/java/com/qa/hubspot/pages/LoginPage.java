package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page Objects / By Locators
	By emailID = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By forgotPassword = By.linkText("Forgot my password");


	// 2. page class constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions/methods:
	@Step("get login page title....")
	public String getLoginPageTitle() {
		elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}

	@Step("checking sigup link is present or not....")
	public boolean isSignUpLinkExists() {
		return elementUtil.doIsDisplayed(signUpLink);
	}

	@Step("login with {0} and {1}")
	public HomePage doLogin(String username, String pwd) {
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		return new HomePage(driver);

	}

}
