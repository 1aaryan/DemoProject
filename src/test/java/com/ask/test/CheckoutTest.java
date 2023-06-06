package com.ask.test;

import com.ask.api.actions.CartAPI;
import com.ask.api.actions.SignupAPI;
import com.ask.base.BaseTest;
import com.ask.objects.BillingAddress;
import com.ask.objects.Product;
import com.ask.objects.User;
import com.ask.pages.CheckoutPage;
import com.ask.utils.FakerUtils;
import com.ask.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends BaseTest {


    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException {
        Product product=new Product(1215);
        BillingAddress billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        CartAPI cartAPI=new CartAPI();
        cartAPI.addToCart(product.getId(),1);

        CheckoutPage checkoutPageObj= new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(cartAPI.getCookies());
        checkoutPageObj.load();

        checkoutPageObj.
                enterFirstName(billingAddress).
                enterLastName(billingAddress).
                selectCountry(billingAddress).
                enterStreetAddress(billingAddress).
                enterCityName(billingAddress).
                selectState(billingAddress).
                enterZip(billingAddress).
                enterEmail(billingAddress).
                clickPlaceOrder();
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException {
        String userName="demo" + new FakerUtils().generateRandomNumber();
        BillingAddress billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

        User user=new User().setId(userName).setEmail(userName + "@askomdch.com").setPassword("demopwd");
        Product product=new Product(1215);
        SignupAPI signupAPI= new SignupAPI();
        signupAPI.register(user);
        CartAPI cartAPI= new CartAPI(signupAPI.getCookies());
        cartAPI.addToCart(product.getId(), 1);

        CheckoutPage checkoutPageObj= new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(signupAPI.getCookies());
        checkoutPageObj.load();
        Assert.assertTrue(checkoutPageObj.getProductName().contains(product.getName()));
        checkoutPageObj.
                enterFirstName(billingAddress).
                enterLastName(billingAddress).
                selectCountry(billingAddress).
                enterStreetAddress(billingAddress).
                enterCityName(billingAddress).
                selectState(billingAddress).
                enterZip(billingAddress).
                enterEmail(billingAddress).
                clickPlaceOrder();
    }
}
