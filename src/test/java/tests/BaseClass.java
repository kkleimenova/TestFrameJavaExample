package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.structure.Page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {


        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("ie")) {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equals("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterTest
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        //driver.close();
    }

    @Test(description = "Verifies google opens")
    public void appOpenTest() throws Exception {
        Page page = new Page(driver);
        page.mainPage
                .openMainPage();
        Assert.assertNotNull(page.mainPage.assertMainPageIsLoaded());
    }

    @Test(description = "Verifies google search")
    public void searchTest() {
        Page page = new Page(driver);
        page.mainPage
                .enterSearchText()
                .clickSubmitButton();
        Assert.assertNotNull(page.resultsPage.assertResultsFound());
        page.resultsPage.redirectOnSearchedElement();


    }
}

