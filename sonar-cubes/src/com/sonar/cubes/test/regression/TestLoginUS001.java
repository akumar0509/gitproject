package com.sonar.cubes.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sonar.cubes.project.utils.CreateDriver;
import com.sonar.cubes.ui.BasePage;
import com.sonar.cubes.ui.LoginPage;
import com.sonar.cubes.utils.GetData;

public class TestLoginUS001 
{
	WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;
	@BeforeMethod
	public void setUp()
	{
		driver = CreateDriver.getDriver();
		loginPage = new LoginPage(driver);
		basePage = new BasePage(driver);
	}
	@Test
	public void testValidLoginTC001()
	{
		String un = GetData.fromExcel("data", "US001", 1, 0);
		String pwd = GetData.fromExcel("data", "US001", 1, 1);
		loginPage.waitForLoginPage();
		loginPage.getUserNameTextbox().sendKeys(un);
		loginPage.getPasswordTextbox().sendKeys(pwd);
		loginPage.getLoginBtn().click();
		basePage.waitForBasePage();
		boolean actual = basePage.getLogoutBtn().isDisplayed();
		Assert.assertEquals(actual, true);
	}
	@AfterMethod
	public void tearDown()
	{
		basePage.getLogoutBtn().click();
		driver.close();
	}
}
