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

public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws IOException {
        String userName="demo" + new FakerUtils().generateRandomNumber();
        Product product=new Product(1215);
        BillingAddress billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        User user=new User().setId(userName).setEmail(userName+"@askomdch.com").setPassword("demopwd");
        SignupAPI signupAPI=new SignupAPI();
        signupAPI.register(user);

        CartAPI cartAPI= new CartAPI();
        cartAPI.addToCart(product.getId(), 1);

        CheckoutPage checkoutPageObj=new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(cartAPI.getCookies());
        checkoutPageObj.load();
        checkoutPageObj.clickToLogin()
                .enterUserName(user)
                .enterPassword(user)
                .clickLoginBtn();

        Assert.assertTrue(checkoutPageObj.getProductName().contains(product.getName()));


    }
}
