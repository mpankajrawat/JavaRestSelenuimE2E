package pankajrawat.ui.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {

	WebDriver driver;
	
	public ScreenShotUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getScreenshot(String testcaseName) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String fileName = testcaseName + "_" + System.currentTimeMillis() + ".png";
        String filePath = System.getProperty("user.dir") + "//reports//" + fileName;
        
		File file = new File(filePath);
		FileUtils.copyFile(source, file);
		return filePath;
	}
}
