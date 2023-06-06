package com.ask.api.actions;

import com.ask.objects.User;
import com.ask.utils.FakerUtils;

public class DummyTest {
    public static void main(String[] args) {
        String userName="demo" + new FakerUtils().generateRandomNumber();
        User user= new User().setId(userName).setPassword("demopwd").setEmail(userName + "@askomdch.com");
        SignupAPI signupAPI=new SignupAPI();
       signupAPI.register(user);
//        System.out.println(signupAPI.getCookies());

        CartAPI cartAPI= new CartAPI(signupAPI.getCookies());
        System.out.println(cartAPI.addToCart(1215,1));
        System.out.println(cartAPI.getCookies());
    }
}
