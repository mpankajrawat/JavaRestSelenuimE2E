package pankajrawat.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajrawat.ui.utility.UiUtils;

public class CartPage extends UiUtils {

	WebDriver driver; 
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//li[contains(@class,'items')]")
	List<WebElement> cartItemList;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement contShoppingBtn;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutBtn;
	
	By myCartTextLocator = By.xpath("//h1[text()='My Cart']");
	By cartItemTextLocator = By.xpath(".//h3");
	
	public void validateCartPageNavigation() {
		waitUntilElement(myCartTextLocator, true);
	}
	
	public List<WebElement> cartItemList(){
	return 	cartItemList;
	}
	
	public boolean validateProductPresentIncart(String productName) {
		boolean presence = cartItemList().stream().anyMatch(cartItem -> cartItem.findElement(cartItemTextLocator)
				.getText()
				.equalsIgnoreCase(productName));
		return presence;
	}
	
	public CheckoutPage clickCheckoutBtn() {
		checkoutBtn.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		checkoutpage.validateCheckoutPageNavigation();
		
		return checkoutpage;
	}
	
}
