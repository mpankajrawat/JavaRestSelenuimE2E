package pankajrawat.test.common.resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pankajrawat.common.resources.ExtentReporterNG;
import pankajrawat.testUtils.ui.BaseUiTest;
import pankajrawat.ui.utility.ScreenShotUtil;

public class Listners implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getRreportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private ExtentTest getTest(ITestResult result) {
        if (extentTest.get() == null) {
            ExtentTest test = extent.createTest(result.getMethod().getMethodName());
            extentTest.set(test);
        }
        return extentTest.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getRealClass().getSimpleName() 
                + " - " + result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);

        test.log(Status.INFO, "TEST EXECUTION STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = getTest(result);
        test.log(Status.PASS, "TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = getTest(result);

        test.log(Status.FAIL, "TEST FAILED");
        test.fail(result.getThrowable());

        if (result.getInstance() instanceof BaseUiTest) {
            WebDriver driver = ((BaseUiTest) result.getInstance()).driver;

            if (driver != null) {
                try {
                    ScreenShotUtil screenshot = new ScreenShotUtil(driver);
                    String filepath = screenshot.getScreenshot(result.getMethod().getMethodName());
                    test.addScreenCaptureFromPath(filepath);
                } catch (IOException e) {
                    test.warning("Screenshot failed: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = getTest(result);

        if (result.getThrowable() != null) {
            test.log(Status.SKIP, "TEST SKIPPED");
            test.skip(result.getThrowable());
        } else {
            test.log(Status.SKIP, "TEST SKIPPED WITH UNKNOWN CAUSE");
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}