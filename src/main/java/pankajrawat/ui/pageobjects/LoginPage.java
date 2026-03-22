package pankajrawat.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajrawat.ui.utility.UiUtils;

public class LoginPage extends UiUtils {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement usernameTxtField;
	
	@FindBy(id="userPassword")
	WebElement passwordTxtField;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='userEmail']//following-sibling::div//div")
	WebElement invaliEmailErrorTxt;
	
	By toastErrorMessage = By.xpath("//div[@id='toast-container']//div[contains(text(),'Incorrect email or password.')]");
	
	public void navigateToLoginPage() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
	}
	
	public HomePage login(String username, String password) {
		
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
		
		HomePage homePage = new HomePage(driver);
//		homePage.validateHomePageNavigation();
		
		return homePage;
		
	}
	
	public String getInvaliEmailErrorText() {
		return invaliEmailErrorTxt.getText();
	}
	
	
	public String getErrorText() {
		waitUntilElement(toastErrorMessage, true);
		return driver.findElement(toastErrorMessage).getText();
	}

}
