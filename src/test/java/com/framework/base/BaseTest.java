package com.framework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framework.BrowserFactory.BrowserFactory;
import com.framework.driver.DriverFactory;
import com.framework.utils.ConfigLoader;

public class BaseTest {
	
	@Parameters({"browser", "env"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser,
                      @Optional("qa") String env) {

        BrowserFactory.initDriver(browser);

        //ENV DECISION POINT
        ConfigLoader.load(env);

        DriverFactory.getDriver()
            .get(ConfigLoader.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.unload();
    }

}
