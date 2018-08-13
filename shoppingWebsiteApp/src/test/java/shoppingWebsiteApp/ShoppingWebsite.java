package shoppingWebsiteApp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingWebsite {

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
		driver.get("http://automationpractice.com/index.php");
		WebElement findSearch = driver.findElementById("search_query_top");
		findSearch.sendKeys("Dress");
		findSearch.submit();

		assertTrue(driver
				.findElementByCssSelector(
						"#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img")
				.isDisplayed());

	}

	@After
	public void teardown() {
		driver.quit();
	}

}