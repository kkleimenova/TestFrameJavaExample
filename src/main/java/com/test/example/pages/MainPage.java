package com.test.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage {

    By searchField = By.id("lst-ib");
    By submitButton = By.id("_fZl");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage enterSearchText() {
        driver.findElement(searchField).sendKeys("text");
        return this;
    }

    public ResultsPage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return new ResultsPage(driver);
    }

    public MainPage assertMainPageIsLoaded() {
        Assert.assertEquals(driver.getTitle(), "Google", "ER: Title is incorrect.");
        return this;
    }

}
