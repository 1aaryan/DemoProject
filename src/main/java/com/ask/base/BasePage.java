package com.ask.base;

import com.ask.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
    this.driver=driver;
    }

    public void load(String endpoint){
        driver.get(ConfigLoader.getInstance().getUrl() + endpoint);
    }

    public WebDriverWait shortWait(){
        return wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

}
