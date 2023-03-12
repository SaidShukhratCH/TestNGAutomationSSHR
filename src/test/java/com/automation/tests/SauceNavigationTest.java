package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class SauceNavigationTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "src//test/resources//driver//chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Loading url in the browser
		driver.get("https://www.saucedemo.com/");
	}

	@Test(groups = { "Smoke", "Chirag", "Navigation" })
	public void verifyUserCanNavigateToProductDetailPageFromHomePage() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("standard_user", "secret_sauce");
		homePage.verifyHomePage();
		homePage.verifyProductDetailPageNavigation();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

}
