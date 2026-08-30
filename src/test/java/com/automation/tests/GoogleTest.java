package com.automation.tests;

import com.automation.core.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void openGoogle(){
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }
}
