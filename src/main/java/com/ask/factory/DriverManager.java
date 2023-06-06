package com.ask.factory;

import com.ask.constants.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public WebDriver initializeDriver(String browser){

        WebDriver driver;

        switch (BrowserType.valueOf(browser)){
            case CHROME -> driver=new ChromeDriver();

            case FIREFOX -> driver=new FirefoxDriver();

            default -> throw new IllegalStateException("Please enter a valid browser name: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
