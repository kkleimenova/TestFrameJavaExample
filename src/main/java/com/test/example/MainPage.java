package com.test.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage {

    By searchField = By.id("lst-ib");
    By submitButton = By.id("_fZl");

    private WebDriver driver;
    private ResultsPage resultsPage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get("http://google.com");
        return this;
    }

    public MainPage enterSearchText() {
        driver.findElement(searchField).sendKeys("text");
        return this;
    }

    public ResultsPage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return resultsPage;
    }

    public void assertMainPageIsLoaded(){
        Assert.assertEquals(driver.getTitle(), "Google", "ER: Title is incorrect.");
    }

    public void assertResultsFound(){

    }

}
