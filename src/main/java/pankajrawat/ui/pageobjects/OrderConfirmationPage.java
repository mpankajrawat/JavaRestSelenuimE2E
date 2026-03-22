package pankajrawat.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajrawat.ui.utility.UiUtils;

public class OrderConfirmationPage extends UiUtils{

	WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='em-spacer-1']//label")
	List<WebElement> orderIdsLocator;
	
	@FindBy(xpath="//table[@class='order-summary']//div//tr")
	List<WebElement> orderIdsList;
	
	By thankYouTextLocator = By.xpath("//h1[contains(text(),' Thankyou for the order. ')]");
	By orderTitleLocator = By.xpath(".//td//div[@class='title']");
	
	public void validateConfirmationPageNavigation() {
		waitUntilElement(thankYouTextLocator, true);
	}
	
	public List<WebElement> getOrderIds() {
		return orderIdsLocator;
	}
	
	public List<WebElement> getOrderList(){
		return orderIdsList;
	}
	
	public boolean validateIsProductPresentInOrder(String productName) {
		boolean presence = getOrderList().stream().anyMatch(order -> order.findElement(orderTitleLocator)
				.getText().equals(productName));
		return presence;
	}
}
