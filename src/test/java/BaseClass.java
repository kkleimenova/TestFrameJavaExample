import com.test.example.pages.PagesNavigation;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    protected WebDriver driver;

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
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @Test(description = "Verifies google search")
    public void searchTest() {
        PagesNavigation navigator = new PagesNavigation(driver);
        navigator.openMainPage().assertMainPageIsLoaded()
                .enterSearchText()
                .clickSubmitButton()
                .assertResultsFound()
                .redirectOnSearchedElement();
    }
}

