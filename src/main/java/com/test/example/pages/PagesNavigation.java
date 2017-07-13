package com.test.example.pages;

import org.openqa.selenium.WebDriver;

public class PagesNavigation {
    WebDriver driver;

    public PagesNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get("http://google.com");
        return new MainPage(driver);
    }
}
