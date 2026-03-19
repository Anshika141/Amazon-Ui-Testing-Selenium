package com.automation.pages;

import org.openqa.selenium.*;

import com.automation.utils.WaitUtils;

public class HomePage {

    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String product) {
        WebElement box = WaitUtils.waitForElement(driver, searchBox);
        box.clear();
        box.sendKeys(product);

        WebElement btn = WaitUtils.waitForClickable(driver, searchBtn);
        btn.click();
    }
}