package ui.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleSearchPage extends BasePage {

    @Autowired
    private SearchResultsPage searchResultsPage;

    private By inputField = By.name("q");
    private By searchButton = By.xpath("//div[@class='VlcLAe']//input[@name = 'btnK']");

    public void visitGoogleSearchPage() {
        visitBasePage();
    }

    public SearchResultsPage fillInputAndSearch(String requestString) {
        setValue(inputField, requestString);
        clickOnElement(searchButton);
        return searchResultsPage;
    }
}
