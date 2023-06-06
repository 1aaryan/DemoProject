package com.ask.test;

import com.ask.base.BaseTest;
import com.ask.pages.HomePage;
import com.ask.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigateFromHomeToStoreUsingMainMenu(){
        StorePage storePageObj =new HomePage(getDriver()).
                load().
                clickOnStoreLink();
        Assert.assertEquals(storePageObj.getTitle(), "Store");
    }
}
