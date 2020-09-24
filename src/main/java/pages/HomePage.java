package pages;

import static org.junit.Assert.assertEquals;
import java.util.List;
import pageObjects.PageObjects;
import utils.Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObjects{

	private WebDriver driver;
	static Logger logger=Logger.getLogger(HomePage.class);
	Utils methods=new Utils();
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public void verifyLocationAndDatePickerBoxIsPresent() throws Exception
	{ 
		try {
			methods.assertTrue(searchbox_location);
			logger.info("Current location search box is displayed");
			methods.assertTrue(calenderBox_date);	
			logger.info("Date picker box is displayed");
		}
		catch (NoSuchElementException e) {
			throw (e);
		}
	}

	public void enterCurrentlocation(String location) throws Exception
	{
		try
		{
			methods.clearText(searchbox_location);
			methods.sendKeys(searchbox_location,location);
		}
		catch(Exception e)
		{
			throw (e);
		}
	}

	public void verifyListOfAvailableCarsAreDisplayed() throws Exception
	{
		try {
			List<WebElement> carList= driver.findElements(By.xpath("//list of cars"));
			for(int i=0;i<carList.size();i++)
			{
				String carName=carList.get(i).getText();
				logger.info(carName+" is available");
			}
		}
		catch (Exception e) {
			throw (e);
		}
	}

	public void verifyAvailabilityBarsOfCar() throws Exception
	{
		try {
			for(int i=0;i<coloursOfAvailabilityBars.size();i++)
			{
				String colourBar=coloursOfAvailabilityBars.get(i).getAttribute("colourBar");
				if((colourBar.equalsIgnoreCase("Grey"))||(colourBar.equalsIgnoreCase("Blue"))||(colourBar.equalsIgnoreCase("Green")))
				{
					logger.info(colourBar+ " colour availability bar displays");
				}
			}
		}
		catch(Exception e)
		{
			logger.info("Expected colour availability bar is not displaying");
			throw (e);
		}
	}

	public void verifySearchScreenIsDisplayedOnTappingLocationField() throws Exception
	{
		try
		{
			methods.tapOnElement(driver,searchbox_location);
			logger.info("User is able to tap on Current location field");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Searchscreen")));
			logger.info("User is able to navigate on tapping Current location field");
		}
		catch(NoSuchElementException e)
		{
			logger.error("User is not able to navigate on tapping Current location field");
			throw (e);
		}
	}


	public void verifyDynamicListAndCurrentLocationFetched(String location) throws Exception
	{
		try
		{
			enterCurrentlocation(location);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dynamic list")));
			List<WebElement> locationList=driver.findElements(By.xpath("//location path"));
			for(int i=0;i<locationList.size();i++)
			{
				String locationFetched=locationList.get(i).getText();
				logger.info(locationFetched + " location is fetched from google maps");
				if(locationFetched.equalsIgnoreCase(location))
				{
					locationList.get(i).click();
					logger.info("Location is selected");
				}
				else
				{
					logger.info("Current Location is not fetched");
				}
			}						
		}	
		catch(Exception e)
		{
			throw (e);
		}
	}

	public void verifyErrorMsgOnEnteringSpecialCharAsLocation(String expectedErrorMsg,String specialChar) throws Exception
	{
		try
		{
			methods.clearText(searchbox_location);
			methods.sendKeys(searchbox_location,specialChar);
			methods.clickEnter(searchbox_location);
			String actualErrormsg=errorMsg_noResults.getText();
			methods.assertEquals(expectedErrorMsg,actualErrormsg);
			logger.info(actualErrormsg+" message displays");
		}	
		catch(Exception e)
		{
			logger.info("Error message is not displaying");
			throw (e);
		}
	}

	public void choseStartAndEndTime(String startTime,String endTime) throws Exception
	{
		try
		{
			methods.clickOnElement(calenderBox_date);

			//passing start time and end time as parameter in xpath
			methods.scrollTo(driver, By.xpath("//li[contains(text(),'" + startTime + "')]"));
			methods.scrollTo(driver, By.xpath("//li[contains(text(),'" + endTime + "')]"));

			methods.clickOnElement(btn_Done);	
			logger.info("Start and End time is chosen");
		}	
		catch(Exception e)
		{
			throw (e);
		}
	}

	public void verifyErrorMessageOnChoosingPastDateRange(String expectedErrorMsg) throws Exception
	{
		try
		{
			methods.clickOnElement(calenderBox_date);
			methods.scrollTo(driver, By.xpath("//li[contains(text(),'" + startDate + "')]"));
			methods.scrollTo(driver, By.xpath("//li[contains(text(),'" + endDate + "')]"));
			methods.clickOnElement(btn_Done);	
			String actualErrorMsg=errorMsg_futureDate.getText();
			assertEquals(expectedErrorMsg, actualErrorMsg);
			logger.info(expectedErrorMsg +" message displays");			
		}	
		catch(Exception e)
		{
			throw (e);
		}
	}

	public void choosePreferredCarfromListOfAvailableCars(String preferredCarName) throws Exception
	{
		try
		{
			List<WebElement> availableCarName=driver.findElements(By.xpath("//li//available cars based on location and date"));
			for(int i=0;i<availableCarName.size();i++)
			{
				String displayedCarName=availableCarName.get(i).getText();
				if(preferredCarName.equalsIgnoreCase(displayedCarName))
				{
					availableCarName.get(i).click();
					logger.info("Preferred car chosen");
				}
				else
				{
					logger.info("Preferred car not available");
				}
			}
		}
		catch (Exception e) {
			throw (e);
		}
	}
}