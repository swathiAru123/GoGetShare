package pages;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjects;
import utils.Utils;

import org.apache.log4j.Logger;

public class PodDetailsPage extends PageObjects{

  WebDriver driver;
  static Logger logger=Logger.getLogger(HomePage.class);
  Utils methods=new Utils();

  public void verifyUserIsOnPodDetailsPage(String expectedTitle)
  {
		String actualTitle=driver.getTitle();
		methods.assertEquals(expectedTitle, actualTitle);
		logger.info("User is on Pod details page");
	}
	
	public void verifyCarDetailsInPodDetailsPage() throws Exception
	{
		try
		{
			String carName=txt_carName.getText();
			logger.info("Car name is "+ carName);
			String estimatedCost=txt_estimatedCost.getText();
			logger.info("Estimated cost is "+ estimatedCost);
			btn_Booking.isDisplayed();
			logger.info("Booking button is displayed");
		}	
		catch(Exception e)
		{
			throw (e);
		}
	}
	
   }