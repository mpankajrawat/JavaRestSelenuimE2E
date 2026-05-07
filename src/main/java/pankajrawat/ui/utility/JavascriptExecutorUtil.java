package pankajrawat.ui.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtil {
	
	private WebDriver driver;
	private JavascriptExecutor jsExe;
	
	public JavascriptExecutorUtil(WebDriver driver) {
		this.driver=driver;
		this.jsExe=(JavascriptExecutor)driver;
	}

	
	public void jsSendKeys(By locator, String text) {
		
		WebElement element = driver.findElement(locator);
		
		jsSendKeys(element, text);
	}

	public void jsSendKeys(WebElement element, String text) {
		jsExe.executeScript("arguments[0].value=arguments[1];", element, text);
	}
	
	
	public void jsClick(By locator) {
		
		WebElement element = driver.findElement(locator);
		
		jsClick(element);
		
	}
	
	public void jsClick(WebElement element) {
		
		jsExe.executeScript("arguments[0].click();", element);
		
	}
	
	public void jsGetDomData() {
		
	}
	
	public void jsHighlightElement(By locator) {
		
		WebElement element = driver.findElement(locator);
		
		jsHighlightElement(element);
		
	}
	
	public void jsHighlightElement(WebElement element) {
		
		jsExe.executeScript("arguments[0].style.border='3px solid red';", element);
		
	}
	
	public void jsScrollIntoViewByPixel(int verticalValue, int horizontalValue) {
		
		jsExe.executeScript("window.scrollBy(arguments[0], arguments[1]);", verticalValue, horizontalValue);
		
	}
	
	public void jsScrollIntoViewByElement(By locator) {
		WebElement element = driver.findElement(locator);
		
		jsScrollIntoViewByElement(element);
	}
	
	public void jsScrollIntoViewByElement(WebElement element) {
		
		jsExe.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
}
