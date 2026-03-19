package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    WebDriver driver;

    By allProducts = By.cssSelector("div[data-component-type='s-search-result']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProduct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for product list
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProducts));

        List<WebElement> products = driver.findElements(allProducts);

        for (WebElement product : products) {
            try {
                WebElement link = product.findElement(By.cssSelector("h2 a"));

                // Scroll to element
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

                // Click using JS (avoids overlay issues)
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

                break;

            } catch (Exception e) {
                // Skip ads or broken elements
                continue;
            }
        }
    }
}