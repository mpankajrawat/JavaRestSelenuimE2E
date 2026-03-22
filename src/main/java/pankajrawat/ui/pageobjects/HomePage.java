package pankajrawat.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajrawat.ui.utility.UiUtils;

public class HomePage extends UiUtils {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> productList;
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cartBtn;
	
	By productListLocator = By.xpath("//div[contains(@class,'mb-3')]");
	By productNameLocator = By.xpath(".//b");
	By productAddToCartBtn = By.xpath(".//button[contains(text(),'Add To Cart')]");
	By productToastLocator = By.xpath("//div[@id='toast-container']");
	By animatorLocator = By.xpath("//*[@class='ng-animating']");
	By homeTextLocator = By.xpath("//section[@id='sidebar']//p[contains(text(),'Home')]");
	
	
	public void validateHomePageNavigation() {
		waitUntilElement(homeTextLocator, true);
	}
	
	public List<WebElement> getProductList() {
		
		waitUntilElement(productListLocator, true);
		return productList;
	}
	
	public WebElement getProductName(String productName) {
		WebElement pro = getProductList().stream()
				.filter(product -> product.findElement(productNameLocator).getText().equals(productName))
				.findFirst()
				.orElse(null);
				
		return pro;
	}
	
	public void addProductToCart(String productName) {
		getProductName(productName).findElement(productAddToCartBtn).click();
		waitUntilElement(productToastLocator, true);
		waitUntilElement( animatorLocator, false);
		
	}
	
	public CartPage clickOnCartIcon() {
		cartBtn.click();
		CartPage cartPage = new CartPage(driver);
		cartPage.validateCartPageNavigation();
		
		return cartPage;
	}	
	
}
