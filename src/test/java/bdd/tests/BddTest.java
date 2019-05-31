package bdd.tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BddTest {
	static String searchTerm;
	public static WebDriver driver;
	// WebElement checkElement1 = driver.findElement(By.xpath(""));

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	// string arg1 is the name of the website from the table
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.manage().window().maximize();
		driver.navigate().to(arg1);

		// driver.manage().window().maximize();
		// driver.get(arg1);
		// // WebElement newElement1 = (new WebDriverWait(driver, 10))
		// //
		// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sb_form\"]/div")));
		// Thread.sleep(1000);
	}

	// arg1 is the search term in the table
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		// WebDriverWait waitBing = (new WebDriverWait(driver, 10));

		Actions action = new Actions(driver);
		searchTerm = arg1;
		action.moveToElement(driver.findElement(By.id("sb_form_q"))).click().sendKeys(searchTerm)
				.moveToElement(driver.findElement(By.id("sb_form_go"))).click().perform();

		// waitBing.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sb_form_q\"]")));
		// WebElement searchBing =
		// driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		// searchBing.sendKeys(arg1);
		// searchBing.submit();
		//
		// waitBing.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b_results\"]")));

		// WebElement checkElement =
		// driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		// // checkElement.click();
		// // checkElement.sendKeys(arg1);
		// // checkElement.submit();
		// // Thread.sleep(2000);
		// Actions action = new Actions(driver);
		// action.moveToElement(checkElement).sendKeys(arg1).perform();
		// Thread.sleep(2000);
		// action.sendKeys(Keys.ENTER).perform();
		// WebElement newElement3 = (new WebDriverWait(driver, 10))
		// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b_header\"]/nav/ul")));

	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {

		WebElement searchCheck = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("b_results")));

		// WebElement searchCheck = driver.findElement(By.id("b_results"));
		assertTrue(searchCheck.getText().contains(searchTerm));

		// WebElement checkSearchWorks =
		// driver.findElement(By.xpath("//*[@id=\"b_results\"]"));
		// assertTrue(checkSearchWorks.isDisplayed());

		// WebElement checkElement = driver.findElement(By.id("b_content"));
		// checkElement.isDisplayed();
		// assertTrue(checkElement.isDisplayed());
		// Thread.sleep(2000);
	}

	// // in this example only one given because they are they same in each test
	// @Given("^the correct web address$")
	// public void the_correct_web_address() {
	// driver.manage().window().maximize();
	// driver.get("http://www.practiceselenium.com/welcome.html");
	//
	// }
	//
	// @When("^I navigate to the 'Menu' page$")
	// public void i_navigate_to_the_Menu_page() {
	// WebElement checkElement = driver
	// .findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
	// checkElement.click();
	//
	// }
	//
	// @Then("^I can browse a list of the available products\\.$")
	// public void i_can_browse_a_list_of_the_available_products() throws
	// InterruptedException {
	//
	// int elementCount = 0;
	//
	// WebElement checkElement1 = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"));
	// if (checkElement1.isDisplayed()) {
	// elementCount++;
	// }
	// WebElement checkElement2 = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong"));
	// checkElement2.isDisplayed();
	// WebElement checkElement3 = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong"));
	// checkElement3.isDisplayed();
	// assertTrue(checkElement1.isDisplayed() && checkElement2.isDisplayed() &&
	// checkElement3.isDisplayed());
	// Thread.sleep(2000);
	//
	// }
	//
	// @When("^I click the checkout button$")
	// public void i_click_the_checkout_button() {
	// WebElement checkElement = driver
	// .findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
	// checkElement.click();
	//
	// }
	//
	// @Then("^I am taken to the checkout page$")
	// public void i_am_taken_to_the_checkout_page() {
	// WebElement checkElement = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong"));
	// checkElement.isDisplayed();
	// assertTrue(checkElement.isDisplayed());
	// // Thread.sleep(2000);
	//
	// }

}
