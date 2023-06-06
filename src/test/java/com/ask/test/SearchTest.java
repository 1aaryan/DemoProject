package com.ask.test;

import com.ask.base.BaseTest;
import com.ask.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchPartialMatch(){
        StorePage storePageObj= new StorePage(getDriver()).
                load().
                enterTextInSearchBox().
                clickOnSearchButton();
        String searchTitle= storePageObj.getTitleAfterSearch();
        Assert.assertEquals(searchTitle, "Search results: “blue”");
    }
}
