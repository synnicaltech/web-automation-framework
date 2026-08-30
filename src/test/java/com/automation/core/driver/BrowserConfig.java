package com.automation.core.driver;

public final class BrowserConfig {

    private BrowserConfig(){}

    public static Browser getBrowser(){
        String browser = System.getProperty("browser", "chrome");
        return switch(browser.toLowerCase()){
            case "chrome" -> Browser.CHROME;
            case "firefox" -> Browser.FIREFOX;
            case "edge" -> Browser.EDGE;
            default -> throw new IllegalArgumentException("Unsupported browser: "+browser);
        };
    }
}
