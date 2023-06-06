package com.ask.pages;

import com.ask.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    //cart page code

    @FindBy(xpath = "//a[normalize-space()='Blue Shoes']")
    WebElement productName;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    WebElement proceedToCheckoutButton;


    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String checkProductName(){
        return shortWait().until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public CheckoutPage clickOnProceedToCheckOut(){
        shortWait().until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
        return new CheckoutPage(driver);
    }

}
