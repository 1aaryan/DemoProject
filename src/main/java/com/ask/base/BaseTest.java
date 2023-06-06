package com.ask.base;

import com.ask.constants.BrowserType;
import com.ask.factory.DriverManager;
import com.ask.utils.CookieUtils;
import io.restassured.http.Cookies;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.lang.model.element.Element;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class BaseTest {


    private ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    protected void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }


    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser){
        browser=System.getProperty("browser", browser);
//        String browser=null;
//        if(browser==null) browser="CHROME";
        setDriver(new DriverManager().initializeDriver(browser));
    }


    @AfterMethod
    public void quitDriver(){
        getDriver().quit();
    }

    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookie=new CookieUtils().convertRestassuredCookieToSeleniumCookie(cookies);
        for(Cookie cookie: seleniumCookie){
            getDriver().manage().addCookie(cookie);
        }
    }
}
