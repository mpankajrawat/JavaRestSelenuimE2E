package pankajrawat.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajrawat.ui.utility.UiUtils;

public class CheckoutPage extends UiUtils {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='CVV Code ']//following-sibling::input")
	WebElement cvvTextField;
	
	@FindBy(xpath = "//div[text()='Name on Card ']//following-sibling::input")
	WebElement nameTextField;
	
	@FindBy(xpath = "//div[text()='Apply Coupon ']//following-sibling::input")
	WebElement cuponTextField;
	
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeorderBtn;
	
	By paymentMethodTextLocator = By.xpath("//div[contains(text(),'Payment Method')]");
	By expMonthDropdown = By.xpath("(//select[@class='input ddl'])[1]");
	By expYearDropdown = By.xpath("(//select[@class='input ddl'])[2]");
	By countryTextFieldSuggestion = By.xpath("//input[@placeholder='Select Country']");
	By countryDropDownSuggestion = By.xpath("//span[text()=' India']");
	
	public void validateCheckoutPageNavigation() {
		waitUntilElement(paymentMethodTextLocator, true);
	}
	
	public void enterCvvDetails(String cvv) {
		cvvTextField.sendKeys(cvv);
	}
	
	public void enterNameDetails(String name) {
		nameTextField.sendKeys(name);
	}
	
	public void enterCuponDetails(String cupon) {
		cuponTextField.sendKeys(cupon);
	}
	
	public void enterExpMonthDetails(String month) {
		selectDropDownByText(expMonthDropdown, month);
	}
	
	public void enterExpYearDetails(String year) {
		selectDropDownByText(expMonthDropdown, year);
	}
	
	public void enterCountryDetails(String contry) {
		actionDropDown(countryTextFieldSuggestion, contry);
		waitUntilElement(countryDropDownSuggestion, true);
		driver.findElement(countryDropDownSuggestion).click();
	}
	
	public OrderConfirmationPage clickPlaceOrderBtn() {
		placeorderBtn.click();
		
		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		ocp.validateConfirmationPageNavigation();
		
		return ocp;
	}
	
	public void enterCardDetails(String cvv, String name, String cupon, String month, String year, String country) {
		enterCvvDetails(cvv);
		enterNameDetails( name);
		enterCuponDetails( cupon);
		enterExpMonthDetails( month);
		enterExpYearDetails( year);
		enterCountryDetails( country);
		
	}
}
