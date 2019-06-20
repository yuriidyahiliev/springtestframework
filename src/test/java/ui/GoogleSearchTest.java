package ui;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ui.pages.GoogleSearchPage;
import ui.pages.SearchResultsPage;

public class GoogleSearchTest extends BaseTest {

    @Autowired
    private GoogleSearchPage googleSearchPage;

    @Autowired
    private SearchResultsPage searchResultsPage;

    @Test
    public void testUserShouldBeAbleToSearchSeleniumInGoogleSearch() {
        final String siteTitle = "Selenium - Web Browser Automation";
        googleSearchPage.visitGoogleSearchPage();
        searchResultsPage = googleSearchPage.fillInputAndSearch(siteTitle);
        searchResultsPage.clickOnLink(siteTitle);
        Assert.assertEquals("Wrong page opened!", siteTitle, searchResultsPage.getTitle());
    }
}
