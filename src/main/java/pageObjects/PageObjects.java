package pageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Swathi
 * PageObject class initializes the objects of Home page, Login page 
 * and Pod details page
 */
public class PageObjects{

	//Login page objects
	@FindBy(id = "username")
	public WebElement txtBox_userName;

	@FindBy(id = "password")
	public WebElement txtBox_password;

	@FindBy(id = "login")
	public WebElement btn_login;

	//Home Page objects
	@FindBy(id = "location")
	public WebElement searchbox_location;

	@FindBy(id = "date")
	public WebElement calenderBox_date;

	@FindBy(xpath = "//contains(@class,'colour of availability bars')")
	public List<WebElement> coloursOfAvailabilityBars;

	@FindBy(linkText = "no results")
	public WebElement errorMsg_noResults;

	@FindBy(name = "StartDate")
	public WebElement startDate;

	@FindBy(name = "EndDate")
	public WebElement endDate;

	@FindBy(id = "done")
	public WebElement btn_Done;

	//Pod details page objects
	@FindBy(id = "Car name")
	public WebElement txt_carName;

	@FindBy(id = "Car cost")
	public WebElement txt_estimatedCost;

	@FindBy(linkText = "booking button")
	public WebElement btn_Booking;

	@FindBy(linkText = "selectDate")
	public WebElement errorMsg_futureDate;

}