package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//@Listeners(ExtentReportListener.class)
@Epic("EPIC - 101 : design a login page feature....")
@Feature("US 1005: create a login page with title, header, sign up and login method")
@Listeners(TestAllureListener.class)
public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}

	@Description("verify login page title test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1, enabled=true)
	public void verifyLoginPageTitleTest() {
		Reporter.log("Test started--> "+ "verifyLoginPageTitleTest" +"\n" );
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Reporter.log("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		Reporter.log("Test ended--> "+ "verifyLoginPageTitleTest" );

	}

	@Description("verify sign up link test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}

	@Description("verify login feature test...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void verifyLoginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyLoggedAccountName());
		Assert.assertEquals(homePage.getLoggedAccountName(), prop.getProperty("accountname"));
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
