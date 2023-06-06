package com.ask.pages;

import com.ask.analyzer.MyTransform;
import com.ask.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners(MyTransform.class)
public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//li[@id='menu-item-1227']//a[@class='menu-link'][normalize-space()='Store']")
    WebElement storeLink;


    public HomePage load(){
        load("/");
        return this;
    }

    public StorePage clickOnStoreLink(){
        storeLink.click();
        return new StorePage(driver);
    }

}
