package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	SoftAssert softAssert;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		softAssert = new SoftAssert();
	}

	@Test(priority = 1)
	public void verifyHomePageHeaderValueTest() {
		softAssert.assertTrue(homePage.verifyHomePageHeader());
		String headerValue = homePage.getHomePageHeader();
		System.out.println("home page header is: " + headerValue);
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER, "home page header mismatched...");
		System.out.println("end of the test.......");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyLoggedInUserTest() {
		softAssert.assertTrue(homePage.verifyLoggedAccountName());
		String accountName = homePage.getLoggedAccountName();
		System.out.println("account Name is: " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyHomePageAppLogo() {
		Assert.assertTrue(homePage.verifyApplicationLogo(), "application logo is not present...");
	}

	@Test(priority = 4)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
