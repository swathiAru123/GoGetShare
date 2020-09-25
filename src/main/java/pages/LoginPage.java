package pages;

import org.apache.log4j.Logger;
import pageObjects.PageObjects;
import utils.Utils;

/**
 * @author Swathi
 * LoginPage class logins GoGetCarShare application 
 * providing user credentials  
 */
public class LoginPage extends PageObjects{

	private static Logger logger=Logger.getLogger(LoginPage.class);
	private Utils utils;

	public LoginPage()
	{
		this.utils=new Utils();
	}

	public void loginToGoGetApplication(String username,String password)
	{
		try
		{
			utils.sendKeys(txtBox_userName, username);
			utils.sendKeys(txtBox_password, password);
			utils.clickOnElement(btn_login);
			logger.info("User is able to login");
		}
		catch(Exception e)
		{
			logger.error("User is not able to login");
			throw (e);
		}
	}

}