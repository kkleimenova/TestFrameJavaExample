package page.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage {

    @FindBy(id = "lst-ib")
    @CacheLookup
    private WebElement searchField;
    @FindBy(id = "_fZl")
    @CacheLookup
    private WebElement submitButton;

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get("http://google.com");
        return this;
    }

    public MainPage enterSearchText() {
        searchField.sendKeys("text");
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public MainPage assertMainPageIsLoaded() {
        Assert.assertEquals(driver.getTitle(), "Google1", "ER: Title is incorrect.");
        return this;
    }

}
