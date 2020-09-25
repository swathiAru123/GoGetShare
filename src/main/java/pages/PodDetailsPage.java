package pages;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjects;
import utils.Utils;
import org.apache.log4j.Logger;

/**
 * @author Swathi
 * PodDetailsPage class verifies the details of the car and 
 * estimated cost of the car
 */
public class PodDetailsPage extends PageObjects{
	private WebDriver driver;
	private static Logger logger=Logger.getLogger(PodDetailsPage.class);
	private Utils utils;

	public PodDetailsPage()
	{
		this.utils=new Utils();
	}

	public void verifyUserIsOnPodDetailsPage(String expectedTitle)
	{
		try {
		String actualTitle=driver.getTitle();
		utils.assertEquals(expectedTitle, actualTitle);
		logger.info("User is on Pod details page");
		}
		catch(Exception e){
			logger.error("User is not in Pod details page");
			throw (e);
		}
	}

	public void verifyCarDetailsInPodDetailsPage() throws Exception
	{
		try
		{
			String carName=txt_carName.getText();
			String estimatedCost=txt_estimatedCost.getText();
			btn_Booking.isDisplayed();
			logger.info("Car details are available"+carName+ "," + estimatedCost);
		}	
		catch(Exception e)
		{
			logger.error("Car details are not available");
			throw (e);
		}
	}

}