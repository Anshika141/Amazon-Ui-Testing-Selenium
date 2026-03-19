package com.automation.pages;

import org.openqa.selenium.*;

import com.automation.utils.WaitUtils;

public class ProductPage {

    WebDriver driver;

    By title = By.id("productTitle");
    By price = By.cssSelector(".a-price-whole");
    By addToCart = By.id("add-to-cart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return WaitUtils.waitForElement(driver, title).getText();
    }

    public String getPrice() {
        return WaitUtils.waitForElement(driver, price).getText();
    }

    public void addToCart() {
        WaitUtils.waitForClickable(driver, addToCart).click();
    }
}