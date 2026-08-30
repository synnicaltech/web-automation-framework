package com.automation.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {

    private DriverFactory(){
        //utility class
    }

    public static WebDriver createDriver(Browser browser){
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        return switch (browser){
            case CHROME -> createChromeDriver(headless);
            case FIREFOX -> createFirefoxDriver(headless);
            case EDGE -> createEdgeDriver(headless);
        };
    }

    private static WebDriver createChromeDriver(boolean headless){
        ChromeOptions options = new ChromeOptions();
        if(headless){
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        }else {
            options.addArguments("--start-maximized");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless){
        FirefoxOptions options = new FirefoxOptions();
        if(headless) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless){
        EdgeOptions options = new EdgeOptions();
        if(headless){
            options.addArguments("--headless");
        }
        options.addArguments("--start-maximized");
        return new EdgeDriver(options);
    }
}
