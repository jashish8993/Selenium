import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class ashish_sourcefile  {
	static Logger logger=LogManager.getLogger(ashish_sourcefile.class);
	public static  String navigate(WebDriver driver ,String url)
	{
		driver.get(url);
		return null;	
	}
	public static String send_keys(WebDriver driver,String locator,String value,String value3)
	{
		switch (value3) { 
		case "xpath":{
			driver.findElement(By.xpath(locator)).sendKeys(value);
			break;
		}
		case "name":{
			driver.findElement(By.name(locator)).sendKeys(value);
			break;
		}
		case "id":
		{
			driver.findElement(By.id(locator)).sendKeys(value);
			break;
		}

		}

		return null;
	}
	public static String click(WebDriver driver, String locator, String value3)
	{
		switch (value3) { 
		case "xpath":
		{
			WebElement we=driver.findElement(By.xpath(locator));
			we.click();
			break;
		}
		case "name":{
			WebElement we=driver.findElement(By.id(locator));
			we.click();
			break;
		}
		case "id":
		{
			WebElement we=driver.findElement(By.id(locator));
			we.click();
			break;
		}
		}
		return null;
	}
	public static String Close(WebDriver driver)
	{
		driver.close();
		return null;
	}
	public static String quit(WebDriver driver)
	{
		driver.quit();
		return null;
	}
	public static String Select(WebDriver driver, String value,String value2,String value4)
	{
		switch (value4)
		{
		case "id":
		{
			Select select=new Select(driver.findElement(By.id(value2)));
			select.selectByVisibleText(value);
			break;
		}
		case "name":
		{
			Select select=new Select(driver.findElement(By.name(value2)));
			select.selectByVisibleText(value);
			break;
		}
		}
		return null;
	}
	public static String deSelect(WebDriver driver, String value,String value2,String value4)
	{
		switch (value4)
		{
		case "id":
		{
			Select select=new Select(driver.findElement(By.id(value2)));
			select.deselectByVisibleText(value);
			break;
		}
		case "name":
		{
			Select select=new Select(driver.findElement(By.name(value2)));
			select.deselectByVisibleText(value);
			break;
		}
		}
		return null;
	}
	public static String Wait(WebDriver driver, String data) 
	{
		Double d = Double.parseDouble(data.trim());
		long l = d.longValue();
		driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);
		return null;
	}
	public static String gettext(WebDriver driver,String locator,String value)
	{
		switch(locator)
		{
		case "xpath":
		{
			driver.findElement(By.xpath(value)).getText();
		}
		case "id":
		{
			driver.findElement(By.id(value)).getText();
		}
		}
		return null;
	}
	public static String submit(WebDriver driver,String locator)
	{
		WebElement we=driver.findElement(By.xpath(locator));
		we.click();
		return null;
	}
	public static String forward(WebDriver driver)
	{
		driver.navigate().forward();
		return null;
	}
	public static String back(WebDriver driver)
	{
		driver.navigate().back();
		return null;
	}
	public static String Title(WebDriver driver)
	{
		driver.getTitle();
		return null;
	}
	public static String curl(WebDriver driver)
	{
		driver.getCurrentUrl();
		return null;
	}
	public static String radiob(WebDriver driver,String locator)
	{
		WebElement we=driver.findElement(By.id(locator));
		we.click();
		return null;
	}
	public static String checkbox(WebDriver driver,String locator)
	{
		WebElement we=driver.findElement(By.id(locator));
		we.click();
		return null;
	}
}
