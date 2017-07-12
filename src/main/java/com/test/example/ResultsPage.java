package com.test.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {
    By resultsList = By.xpath("//h3[@class='r']/a[0]");

    public WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage redirectOnSearchedPage(){
        driver.findElement(resultsList).click();
        return this;
    }

}
