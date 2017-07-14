package page.structure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    public MainPage mainPage;
    public ResultsPage resultsPage;

    public Page(WebDriver driver) {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
    }

}
