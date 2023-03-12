package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class SauceLoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "src//test/resources//driver//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Maximize
		driver.manage().window().maximize();

		// Loading url in the browser
		driver.get("https://www.saucedemo.com/");
	}

	@Test(groups = { "Regression", "Umed", "Login" })
	public void verifyUserCannotDoLoginWithInvalidCred() {
		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("testtest","test@123");

		// Login page error
		loginPage.verifyInvalidLoginError();
	}

	@Test(groups = { "Regression", "Login" })
	public void verifyUserCanAbleToLogin() {
		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("standard_user","secret_sauce");

		// Verify Home Page
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

}
