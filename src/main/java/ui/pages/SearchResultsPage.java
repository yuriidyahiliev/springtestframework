package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ui.pojo.SearchResultsItemText;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchResultsPage extends BasePage {

    private By searchResult = By.xpath( "//div[@class='g']");

    public List<SearchResultsItemText> getSearchResultList() {

        List<SearchResultsItemText> itemTexts = new ArrayList<>();

        for (WebElement item : elements(searchResult)) {
            SearchResultsItemText resultsItemText = new SearchResultsItemText();

            String head = item.findElement(By.xpath(".//h3")).getText();
            String link = item.findElement(By.xpath(".//cite")).getText();

            resultsItemText.setDescription(head);
            resultsItemText.setUrl(link);
            itemTexts.add(resultsItemText);
        }

        return itemTexts;
    }

    public void clickOnLink(String head) {
        visitUrl(getSearchResultList()
                .stream()
                .filter(x -> x.getDescription().contentEquals(head))
                .map(SearchResultsItemText::getUrl)
                .collect(Collectors.joining()));
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }
}
