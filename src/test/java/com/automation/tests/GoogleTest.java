package com.automation.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        this.driver = new ChromeDriver();
    }

    @Test
    public void openGoogle(){
        this.driver.get("https://www.google.com");
        this.driver.manage().window().maximize();
        Assertions.assertEquals("Google", this.driver.getTitle());
    }

    @AfterEach
    public void tearDown(){
        if(this.driver != null){
            this.driver.quit();
        }
    }
}
