package pankajrawat.ui.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiUtils {

	private WebDriver driver;
	
	public UiUtils(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void waitUntilElement(By locator, boolean flag) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(flag==true) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		else if(flag==false) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}		
	}
	
//	/-------------------------------------SELECT DROPDOWN UTILS-----------------------------------------------------/
	
	public void selectDropDownByText(By locator, String value) {
		WebElement element = driver.findElement(locator);
		
		Select select = new Select(element);
		select.selectByVisibleText(value);
				
	}
	
	public void selectDropDownByText(By locator, int index) {
		WebElement element = driver.findElement(locator);
		
		Select select = new Select(element);
		select.selectByIndex(index);
				
	}
	
	public void selectDropDownByValue(By locator, String value) {
		WebElement element = driver.findElement(locator);
		
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
//	/--------------------------------------------------------------------------------------------------------------/
	
//	/---------------------------------ACTIONS CLASS UITLS----------------------------------------------------------/
	
	public void actionClick(By locator) {
		WebElement element = driver.findElement(locator);
		
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}
	
	public void actionRightClick(By locator) {
		WebElement element = driver.findElement(locator);
		
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();;
	}
	
	public void actionsDoubbleClick(By locator) {
		WebElement element = driver.findElement(locator);
		
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	
	public void actionSendKeys(By locator, String value) {
		WebElement element = driver.findElement(locator);
		
		Actions act = new Actions(driver);
		act.sendKeys(element, value).build().perform();
	}
	
	public void actionDropDown(By locator, String value) {
		Actions action = new Actions(driver);
		
		action.sendKeys(driver.findElement(locator), value).build().perform();
	}
	
}
