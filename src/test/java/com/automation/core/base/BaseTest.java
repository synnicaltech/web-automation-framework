package com.automation.core.base;

import com.automation.core.driver.Browser;
import com.automation.core.driver.BrowserConfig;
import com.automation.core.driver.DriverFactory;
import com.automation.core.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        Browser browser = BrowserConfig.getBrowser();
        WebDriver webDriver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(webDriver);
        driver = DriverManager.getDriver();

    }

    @AfterEach
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
