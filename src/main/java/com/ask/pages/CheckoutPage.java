package com.ask.pages;

import com.ask.base.BasePage;
import com.ask.objects.BillingAddress;
import com.ask.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement firstNameFld;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement lastNameFld;

    @FindBy(id = "billing_country")
    WebElement countryDropdown;

    @FindBy(id = "billing_state")
    WebElement stateDropdown;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement streetAddressFld;

    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement cityFld;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement zipFld;

    @FindBy(xpath = "//input[@id='billing_email']")
    WebElement emailFld;

    @FindBy(xpath = "//button[@id='place_order']")
    WebElement placeOrder;

    @FindBy(xpath = "//a[@class='showlogin']")
    WebElement loginLink;

    @FindBy (xpath = "//button[@name='login']")
    WebElement loginBtn;

    @FindBy(xpath = "//td[@class='product-name']")
    WebElement productName;
    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy (css = "#payment_method_bacs")
    WebElement directBankTransferRadio;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage load(){
        load("/checkout");
        return this;
    }


    public CheckoutPage enterFirstName(BillingAddress billingAddress){
        shortWait().until(ExpectedConditions.visibilityOf(firstNameFld)).clear();
        firstNameFld.sendKeys(billingAddress.getFirstNameFld());
        return this;
    }
    public CheckoutPage enterLastName(BillingAddress billingAddress){
        shortWait().until(ExpectedConditions.visibilityOf(lastNameFld)).clear();
        lastNameFld.sendKeys(billingAddress.getLastNameFld());
        return this;
    }

    public CheckoutPage selectCountry(BillingAddress billingAddress){
        Select select= new Select(countryDropdown);
        select.selectByVisibleText(billingAddress.getCountryName());
        return this;
    }
    public CheckoutPage selectState(BillingAddress billingAddress){
        Select select= new Select(stateDropdown);
        select.selectByVisibleText(billingAddress.getStateName());
        return this;
    }
    public CheckoutPage enterStreetAddress(BillingAddress billingAddress){
        streetAddressFld.clear();
        streetAddressFld.sendKeys(billingAddress.getStreetAddressFld());
        return this;
    }
    public CheckoutPage enterCityName(BillingAddress billingAddress){
        cityFld.clear();
        cityFld.sendKeys(billingAddress.getCityFld());
        return this;
    }
    public CheckoutPage enterZip(BillingAddress billingAddress){
        zipFld.clear();
        zipFld.sendKeys(billingAddress.getZipFld());
        return this;
    }
    public CheckoutPage enterEmail(BillingAddress billingAddress){
        emailFld.clear();
        emailFld.sendKeys(billingAddress.getEmailFld());
        return this;
    }
    public CheckoutPage clickToLogin(){
        shortWait().until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        return this;
    }
    public CheckoutPage enterUserName(User user){
        shortWait().until(ExpectedConditions.elementToBeClickable(userName)).clear();
        userName.sendKeys(user.getId());
        return this;
    }

    public CheckoutPage enterPassword(User user){
        shortWait().until(ExpectedConditions.elementToBeClickable(password)).clear();
        password.sendKeys(user.getPassword());
        return this;
    }

    public CheckoutPage clickLoginBtn(){
        shortWait().until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return this;
    }

    public String getProductName(){
        return shortWait().until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public CheckoutPage checkDirectBankTransferRadio(){
       if(!directBankTransferRadio.isSelected()){
           directBankTransferRadio.click();
       }
       return this;
    }


    public void clickPlaceOrder(){
        List<WebElement> ele=driver.findElements(By.cssSelector(".blockUI.blockOverlay"));
        shortWait().until(ExpectedConditions.invisibilityOfAllElements(ele));
        placeOrder.click();

    }
}
