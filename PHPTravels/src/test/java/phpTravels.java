import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class phpTravels {

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
		driver.get("https://www.phptravels.net/");
		WebElement searchHotel = driver.findElementById("s2id_autogen9");
		searchHotel.sendKeys("London");
		WebElement searchStartDate = driver.findElementById("dpd1");
		searchStartDate.sendKeys("17/08/2018");
		WebElement searchEndDate = driver.findElementById("dpd2");
		searchEndDate.sendKeys("17/08/2018");
		WebElement noOfPeople = driver.findElementByClassName("bgfade col-md-2 form-group go-right col-xs-12");
		noOfPeople.clear();
		noOfPeople.sendKeys("3");
		noOfPeople.submit();
		
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
