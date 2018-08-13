package testApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSite {
	ChromeDriver driver;

	@BeforeClass
	public static void set() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
	}

	@Before
	public void setup() {
		driver = new ChromeDriver();

	}

	@Test
	public void test() {
		driver.manage().window().maximize();
		driver.get("http:\\thedemosite.co.uk");
		WebElement findLogin = driver.findElement(By.cssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		findLogin.click();
		WebElement createUsername = driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input");
		createUsername.sendKeys("user1");
		WebElement createPassword = driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]");
		createPassword.sendKeys("pass");
		WebElement saveUser = driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]");
		saveUser.click();

		WebElement goLogin = driver.findElementByCssSelector(
				"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)");
		goLogin.click();
		WebElement enterUsername = driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input");
		WebElement enterPassword = driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]");
		enterUsername.sendKeys("user1");
		enterPassword.sendKeys("pass");
		WebElement login = driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]");
		login.click();

		assertEquals(driver.findElementByCssSelector(
				"body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
				.getText(), "**Successful Login**");

	}

	@After
	public void teardown() {
		driver.quit();
	}

}
