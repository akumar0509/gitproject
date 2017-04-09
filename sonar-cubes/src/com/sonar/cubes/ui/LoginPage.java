package com.sonar.cubes.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	public void waitForLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.
				visibilityOfAllElementsLocatedBy(By.name("LoginForm")));
	}
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getUserNameTextbox()
	{
		WebElement element = driver.findElement(By.name("username"));
		return element;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginBtn()
	{
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	public WebElement getLoginErrorMessage()
	{
		return driver.findElement(By.xpath("(//span[@class='errormsg'])[1]"));
	}
}





