package com.test.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    @FindBy(id="lst-ib")
    @CacheLookup
    private WebElement searchField;
    @FindBy(id="_fZl")
    @CacheLookup
    private WebElement submitButton;

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage() {
        driver.get("http://google.com");
        return new MainPage(driver);
    }

    public MainPage enterSearchText() {
        searchField.sendKeys("text");
        return this;
    }

    public ResultsPage clickSubmitButton() {
        submitButton.click();
        return new ResultsPage(driver);
    }

    public MainPage assertMainPageIsLoaded() {
        Assert.assertEquals(driver.getTitle(), "Google", "ER: Title is incorrect.");
        return this;
    }

}
