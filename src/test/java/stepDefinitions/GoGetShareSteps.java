package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import pages.PodDetailsPage;

public class GoGetShareSteps {
	private LoginPage loginPage;
	private HomePage homePage;
	private PodDetailsPage podDetailsPage;
	WebDriver driver;

	public GoGetShareSteps()
	{
		this.homePage=new HomePage();
		this.loginPage=new LoginPage();
		this.podDetailsPage=new PodDetailsPage();
	}

	@Given("^Launch GoGetShare Application")
	public void launchGoGetShareApplication()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gogetshare.com");
	}

	@And("^Login to GoGetShare Application")
	public void loginToGoGetApplication()
	{
		loginPage.loginToGoGetApplication();
	}

	@And("^Verify Location and Datepicker box functionality")
	public void verifyLocationAndDatePickerBoxIsPresent() throws Exception
	{
		homePage.verifyLocationAndDatePickerBoxIsPresent();
	}

	@Then("^Enter Current location as \"([^\"]*)\"")
	public void enterCurrentlocation(String location) throws Exception
	{
		homePage.enterCurrentlocation(location);
	}

	@Then("^Verify list of available cars are displaying in home page")
	public void verifyListOfAvailableCarsAreDisplayed() throws Exception
	{
		homePage.verifyListOfAvailableCarsAreDisplayed();
	}

	@And("^Verify availability bars are displaying in home page")
	public void verifyAvailabilityBarsAreDisplayed() throws Exception
	{
		homePage.verifyAvailabilityBarsOfCar();
	}

	@And("^Verify search screen is displaying on tapping Location field")
	public void verifySearchScreenIsDisplayedOnTappingLocationFiled() throws Exception
	{
		homePage.verifySearchScreenIsDisplayedOnTappingLocationField();
	}

	@And("^Verify dynamic list and current location are fetched on entering location \"([^\"]*)\"")
	public void verifyDynamicListAndCurrentLocationFetched(String location) throws Exception
	{
		homePage.verifyDynamicListAndCurrentLocationFetched(location);
	}

	@And("^Verify error message \"([^\"]*)\" displaying on entering special char \"([^\"]*)\"")
	public void verifyErrorMsgOnEnteringSpecialCharAsLocation(String expectedErrorMsg,String specialChar) throws Exception
	{
		homePage.verifyErrorMsgOnEnteringSpecialCharAsLocation(expectedErrorMsg,specialChar);;
	}

	@Then("^Choose Start time as \"([^\"]*)\" and End time as \"([^\"]*)\"")
	public void ChooseStartAndEndDate(String startTime,String endTime) throws Exception
	{
		homePage.choseStartAndEndTime(startTime,endTime);
	}
	
	@Then("^Verify error message \"([^\"]*)\" displays on entering past date range")
	public void verifyErrorMessageOnChoosingPastDateRange(String expectedErrorMsg) throws Exception
	{
		homePage.verifyErrorMessageOnChoosingPastDateRange(expectedErrorMsg);
	}
	
	@Then("^Choose car \"([^\"]*)\"")
	public void choosePreferredCarfromListOfAvailableCars(String preferredCar) throws Exception
	{
		homePage.choosePreferredCarfromListOfAvailableCars(preferredCar);
	}
	
	@And("^Verify user is navigated to Pod details page by verifying page title \"([^\"]*)\"")
	public void verifyUserIsOnPodDetailsPage(String expectedTitle) throws Exception
	{
		podDetailsPage.verifyUserIsOnPodDetailsPage(expectedTitle);
	}
	
	@And("^Verify car details in Pod Details page")
	public void verifyCarDetailsInPodDetailsPage() throws Exception
	{
		podDetailsPage.verifyCarDetailsInPodDetailsPage();
	}
	
}
