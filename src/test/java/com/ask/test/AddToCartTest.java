package com.ask.test;

import com.ask.base.BaseTest;
import com.ask.objects.Product;
import com.ask.pages.CartPage;
import com.ask.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Product product= new Product(1215);
        CartPage cartPageObj = new StorePage(getDriver()).load().
                clickAddToCart(product.getName()).
                clickOnViewCart();
        Assert.assertEquals(cartPageObj.checkProductName(), product.getName());
    }
}
