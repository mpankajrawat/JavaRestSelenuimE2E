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

	WebDriver driver;
	
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
	
	public void selectDropDown(By locator, String value) {
		WebElement element = driver.findElement(locator);
		
		Select select = new Select(element);
		select.selectByVisibleText(value);
				
	}
	
	public void actionDropDown(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(locator), value).build().perform();
	}
	
}
