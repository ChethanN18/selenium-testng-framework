package com.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
        if (extent == null) {

            String timeStamp = 
                java.time.LocalDateTime.now()
                    .toString()
                    .replace(":", "_");

            ExtentSparkReporter reporter =
                new ExtentSparkReporter(
                    "reports/ExtentReport_" + timeStamp + ".html"
                );

            reporter.config().setReportName("Automation Test Results");
            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Execution", "Parallel");
        }
        return extent;
    }

}
