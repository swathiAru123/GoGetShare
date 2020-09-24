package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PageObjects;

public class LoginPage extends PageObjects{

	WebDriver driver;
	public void launchGoGetShareApplication()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gogetshare.com");
	}

	public void loginToGoGetApplication()
	{
		txtBox_userName.sendKeys("name");
		txtBox_password.sendKeys("password");
		btn_login.click();
	}



}