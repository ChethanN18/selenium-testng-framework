package com.framework.listeners;

import org.testng.ITestResult;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.framework.reporting.ExtentManager;
import com.framework.reporting.ExtentTestManager;
import com.framework.utils.ScreenshotUtils;

public class TestListener implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtils.capture(result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .log(Status.FAIL, result.getThrowable());

        if (path != null) {
            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
