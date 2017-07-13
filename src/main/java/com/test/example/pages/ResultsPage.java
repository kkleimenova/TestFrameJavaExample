package com.test.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResultsPage {
    By resultsListElement = By.xpath("//h3[@class='r']/a");

    public WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void redirectOnSearchedElement() {
        driver.findElement(resultsListElement).click();
    }

    public ResultsPage assertResultsFound() {
        Assert.assertNotNull(driver.findElements(resultsListElement), "ER: Search result is not found.");
        return this;
    }
}
