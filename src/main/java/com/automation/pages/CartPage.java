package com.automation.pages;

import org.openqa.selenium.*;

import com.automation.utils.WaitUtils;

public class CartPage {

    WebDriver driver;

    By productName = By.cssSelector(".sc-product-title");
    By productPrice = By.cssSelector(".sc-product-price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartProductName() {
        return WaitUtils.waitForElement(driver, productName).getText();
    }

    public String getCartPrice() {
        return WaitUtils.waitForElement(driver, productPrice).getText();
    }
}