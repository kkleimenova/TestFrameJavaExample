package com.test.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ResultsPage{
    @FindBy(xpath = "//h3[@class='r']/a")
    private WebElement resultsListElement;

    public WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver=driver;
    }

    public void redirectOnSearchedElement() {
        resultsListElement.click();
    }

    public ResultsPage assertResultsFound(){
        Assert.assertNotNull(resultsListElement, "ER: Search result is not found.");
        return this;
    }
}
