package pankajrawat.testUtils.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pankajrawat.testUtils.BaseTest;
import pankajrawat.ui.pageobjects.LoginPage;

public class BaseUiTest extends BaseTest {
	
	public WebDriver driver;
	public LoginPage loginpage;

	public WebDriver initilizeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//pankajrawat//ui//resources//propertesFiles//GlobalData.properties");
		prop.load(fis);
		
		String browser = System.getProperty("Browser")!=null ? System.getProperty("Browser") : prop.getProperty("Browser");
		
		if(browser.contains("Chrome")) {
			ChromeOptions co = new ChromeOptions();
			if(browser.contains("Headless")) {
				co.addArguments("Headless");
			}
			co.addArguments("--disable-notifications");
			co.addArguments("--disable-save-password-bubble");
			
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);

			co.setExperimentalOption("prefs", prefs);
			
			driver = WebDriverManager.chromedriver().capabilities(co).create();
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			// Disable notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			// Disable password manager
			profile.setPreference("signon.rememberSignons", false);
			// Disable password breach alerts (approx equivalent)
			profile.setPreference("signon.management.page.breach-alerts.enabled", false);
			
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			
			// Start maximized
			options.addArguments("--start-maximized");

			driver = WebDriverManager.firefoxdriver().capabilities(options).create();
		}
		
		else if(browser.equalsIgnoreCase("Safari")) {
			SafariOptions options = new SafariOptions();

			driver = new SafariDriver(options);
		}
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApp() throws IOException {
		driver = initilizeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigateToLoginPage(); 
		return loginpage;	
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.quit();
	}
}
