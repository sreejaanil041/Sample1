package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.ScreenShotUtility;

public class Base {
public WebDriver driver;

@BeforeMethod
public void initializeBrowser() {
	driver= new ChromeDriver();
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
}

@AfterMethod
public void driverQuit(ITestResult iTestResult) throws IOException {

	if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenShotUtility screenShot = new ScreenShotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
	}
	driver.quit();

} // iTestResult.getStatus() ➝ Returns an integer (e.g., 1, 2

}
