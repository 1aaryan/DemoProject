package com.ask.pages;

import com.ask.analyzer.MyTransform;
import com.ask.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;

@Listeners(MyTransform.class)
public class StorePage extends BasePage {

    @FindBy(xpath = "//input[@id='woocommerce-product-search-field-0']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//h1[@class='woocommerce-products-header__title page-title']")
    WebElement title;


//    @FindBy(xpath = "//a[@aria-label='Add “Blue Shoes” to your cart']")
//    WebElement addToCartButton;

//    private final By addToCartButton= By.xpath("//a[@href='?add-to-cart=1215']");

    @FindBy(xpath = "//a[@title='View cart']")
    WebElement viewCartLink;

    public StorePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public StorePage load(){
        load("/store");
        return this;
    }

    public StorePage enterTextInSearchBox(){
        searchBox.clear();
        searchBox.sendKeys("blue");
        return this;
    }

    public StorePage clickOnSearchButton(){
        shortWait().until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public String getTitle(){
        shortWait().until(ExpectedConditions.urlContains("store"));
        return title.getText();

    }
    public String getTitleAfterSearch(){
        shortWait().until(ExpectedConditions.urlContains("?s"));
        return title.getText();
    }

    public StorePage clickAddToCart(String name){
        shortWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Add “"+name+"” to your cart']"))).click();
        return this;
    }

    public CartPage clickOnViewCart(){
        shortWait().until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }
}
