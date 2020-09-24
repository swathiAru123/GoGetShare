package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utils{

	public void tapOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click();
	}
	
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public void sendKeys(WebElement element,String enter)
	{
		element.sendKeys(enter);
	}
	
	public void assertTrue(WebElement element)
	{
		Assert.assertTrue(element.isDisplayed());
	}
	
	public void assertEquals(String expectedMsg,String ActualMsg)
	{
		Assert.assertEquals(expectedMsg,ActualMsg);
	}
	
	public void clickEnter(WebElement element)
	{
		element.sendKeys(Keys.ENTER);
	}
	
	public void clearText(WebElement element)
	{
		element.clear();
	}
	
	public void scrollTo(WebDriver driver,By xpath)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("arguments[0]. scrollIntoView(true);",xpath);
	}
	  
}