package com.ask.test;

import com.ask.analyzer.MyTransform;
import com.ask.analyzer.RetryAnalyzer;
import com.ask.base.BaseTest;
import com.ask.objects.BillingAddress;
import com.ask.objects.Product;
import com.ask.objects.User;
import com.ask.pages.CartPage;
import com.ask.pages.CheckoutPage;
import com.ask.pages.HomePage;
import com.ask.pages.StorePage;
import com.ask.utils.JacksonUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
@Listeners(MyTransform.class)
public class CheckoutPageTest extends BaseTest {
    HomePage homePageObj;
    CheckoutPage checkoutPageObj;
    Product product;
    BillingAddress billingAddress;

    User user;

//    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        homePageObj=new HomePage(getDriver()).load();
        product=new Product(1215);
        checkoutPageObj=homePageObj.clickOnStoreLink()
                .enterTextInSearchBox()
                .clickOnSearchButton()
                .clickAddToCart(product.getName())
                .clickOnViewCart()
                .clickOnProceedToCheckOut();
        billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        user=JacksonUtils.deserializeJson("user.json", User.class);
        checkoutPageObj.
                enterFirstName(billingAddress)
                .enterLastName(billingAddress)
                .selectCountry(billingAddress)
                .enterStreetAddress(billingAddress)
                .enterCityName(billingAddress)
                .selectState(billingAddress)
                .enterZip(billingAddress)
                .enterEmail(billingAddress)
                .checkDirectBankTransferRadio()
                .clickPlaceOrder();
    }

//    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        homePageObj=new HomePage(getDriver()).load();
        product=new Product(1215);
        checkoutPageObj=homePageObj.clickOnStoreLink()
                .enterTextInSearchBox()
                .clickOnSearchButton()
                .clickAddToCart(product.getName())
                .clickOnViewCart()
                .clickOnProceedToCheckOut();
        billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        user=JacksonUtils.deserializeJson("user.json", User.class);
        checkoutPageObj.clickToLogin()
                .enterUserName(user)
                .enterPassword(user)
                .enterFirstName(billingAddress)
                .selectCountry(billingAddress)
                .enterLastName(billingAddress)
                .enterStreetAddress(billingAddress)
                .enterCityName(billingAddress)
                .selectState(billingAddress)
                .enterZip(billingAddress)
                .enterEmail(billingAddress)
                .checkDirectBankTransferRadio()
                .clickPlaceOrder();

    }

}
