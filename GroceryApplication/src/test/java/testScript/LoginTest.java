package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;

public class LoginTest extends Base {

	@Test(dataProvider = "loginProvider")
	public void verify_LoginPage_with_valid_username_and_valid_password() {
		WebElement loginField = driver.findElement(By.name("username"));
		loginField.sendKeys("admin");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.className("btn btn-dark btn-block"));
		loginButton.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Home - Maxfest Enterprises PVT LTD, Kochi";
		Assert.assertEquals(actualTitle, expectedTitle,"Login failed for valid credentials");
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

	
	@Test
	public void verify_LoginPage_with_invalid_username_and_valid_password() {
		String expectedResult ="These credentials do not match our records.";
		WebElement loginField = driver.findElement(By.name("username"));
		loginField.sendKeys("admin123");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.className("btn btn-dark btn-block"));
		loginButton.click();
		String errorMessage= driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult);
	}
	
	@Test
	public void verify_LoginPage_with_valid_username_and_invalid_password() {
		String expectedResult ="These credentials do not match our records.";
		WebElement loginField = driver.findElement(By.name("username"));
		loginField.sendKeys("admin123");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.className("btn btn-dark btn-block"));
		loginButton.click();
		String errorMessage= driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult);
	}
	
	@Test
	public void verify_LoginPage_with_invalid_username_and_invalid_password() {
		String expectedResult ="These credentials do not match our records.";
		WebElement loginField = driver.findElement(By.name("username"));
		loginField.sendKeys("admin123");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.className("btn btn-dark btn-block"));
		loginButton.click();
		String errorMessage= driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult);
	}
}
