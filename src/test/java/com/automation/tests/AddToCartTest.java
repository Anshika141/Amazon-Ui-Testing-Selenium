package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.*;

import java.util.Set;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCart() {

        // Step 1: Search product
        HomePage home = new HomePage(driver);
        home.searchProduct("iPhone");

        // Step 2: Click first product
        SearchResultsPage results = new SearchResultsPage(driver);

        // Store current window
        String parentWindow = driver.getWindowHandle();

        results.clickFirstProduct();

        // Step 3: Switch to NEW TAB properly
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Step 4: Product page
        ProductPage product = new ProductPage(driver);

        String expectedName = product.getTitle();
        String expectedPrice = product.getPrice();

        product.addToCart();

        // Step 5: Go to cart
        driver.get("https://www.amazon.in/gp/cart/view.html");

        CartPage cart = new CartPage(driver);

        // Step 6: Validation
        Assert.assertTrue(cart.getCartProductName().contains(expectedName));
        Assert.assertEquals(cart.getCartPrice(), expectedPrice);
    }
}