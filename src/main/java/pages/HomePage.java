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

/**
 * @author Swathi
 * HomePage class describes the location, date picker functionality and 
 * list of available cars on the landing page
 */
public class HomePage extends PageObjects{

	private WebDriver driver;
	private static Logger logger=Logger.getLogger(HomePage.class);
	private Utils utils;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	private String availablityColourBar="Green";
	private String bookedBySomeoneColourBar="Grey";
	private String bookedByCurrentUserColourBar="Blue";

	public HomePage()
	{
		this.utils=new Utils();
	}

	public void verifyLocationAndDatePickerBoxIsPresent() throws Exception
	{ 
		try {
			utils.assertTrue(searchbox_location);
			utils.assertTrue(calenderBox_date);	
			logger.info("Current location search box and Date picker box is displayed");
		}
		catch (NoSuchElementException e) {
			logger.error("Current location search box and Date picker box is not displayed");
			throw (e);
		}
	}

	public void enterCurrentlocation(String location) throws Exception
	{
		try
		{
			utils.clearText(searchbox_location);
			utils.sendKeys(searchbox_location,location);
			logger.info("Entered current location");
		}
		catch(Exception e)
		{
			logger.error("User is not able to enter the current location");
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
			logger.error("List of available cars are not displaying");
			throw (e);
		}
	}

	public void verifyAvailabilityBarsOfCar() throws Exception
	{
		try {
			for(int i=0;i<coloursOfAvailabilityBars.size();i++)
			{
				String colourBar=coloursOfAvailabilityBars.get(i).getAttribute("colourBar");
				if((colourBar.equalsIgnoreCase(bookedBySomeoneColourBar))||(colourBar.equalsIgnoreCase(bookedByCurrentUserColourBar))||(colourBar.equalsIgnoreCase(availablityColourBar)))
				{
					logger.info(colourBar+ " colour availability bar displays");
				}
			}
		}
		catch(Exception e)
		{
			logger.error("Expected colour availability bar is not displaying");
			throw (e);
		}
	}

	public void verifySearchScreenIsDisplayedOnTappingLocationField() throws Exception
	{
		try
		{
			utils.tapOnElement(searchbox_location);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Searchscreen")));
			logger.info("User is able to navigate to searc on tapping lohcation field");
		}
		catch(NoSuchElementException e)
		{
			logger.error("User is not able to navigate to search screen on tapping location field");
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
				}
				else
				{
					logger.info("Current Location is not fetched");
				}
			}						
		}	
		catch(Exception e)
		{
			logger.error("Current location not fetched");
			throw (e);
		}
	}

	public void verifyErrorMsgOnEnteringSpecialCharAsLocation(String expectedErrorMsg,String specialChar) throws Exception
	{
		try
		{
			utils.clearText(searchbox_location);
			utils.sendKeys(searchbox_location,specialChar);
			utils.clickEnter(searchbox_location);
			String actualErrormsg=errorMsg_noResults.getText();
			utils.assertEquals(expectedErrorMsg,actualErrormsg);
			logger.info(actualErrormsg+" message displays");
		}	
		catch(Exception e)
		{
			logger.error("Error message is not displaying");
			throw (e);
		}
	}

	public void choseStartAndEndTime(String startTime,String endTime) throws Exception
	{
		try
		{
			utils.clickOnElement(calenderBox_date);
			//passing start time and end time as parameter in xpath
			utils.scrollTo(By.xpath("//li[contains(text(),'" + startTime + "')]"));
			utils.scrollTo(By.xpath("//li[contains(text(),'" + endTime + "')]"));
			utils.clickOnElement(btn_Done);	
			logger.info("Start and End time is chosen");
		}	
		catch(Exception e)
		{
			logger.error("User is not able to choose start and end time");
			throw (e);
		}
	}

	public void verifyErrorMessageOnChoosingPastDateRange(String expectedErrorMsg) throws Exception
	{
		try
		{
			utils.clickOnElement(calenderBox_date);
			utils.scrollTo(By.xpath("//li[contains(text(),'" + startDate + "')]"));
			utils.scrollTo(By.xpath("//li[contains(text(),'" + endDate + "')]"));
			utils.clickOnElement(btn_Done);	
			String actualErrorMsg=errorMsg_futureDate.getText();
			assertEquals(expectedErrorMsg, actualErrorMsg);
			logger.info(expectedErrorMsg +" message displays");			
		}	
		catch(Exception e)
		{
			logger.error("Expected error message is not displaying on choosing past date range");
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
			logger.error("User is not able to chose the preferred car");
			throw (e);
		}
	}
}