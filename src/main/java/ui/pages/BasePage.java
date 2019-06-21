package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ui.utils.BrowserConfig;

import java.util.List;

@Component
public abstract class BasePage {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    public void context(ApplicationContext context) {
        this.applicationContext = context;
    }

    protected WebDriverWait getWebDriverWait() {
        return applicationContext.getBean(BrowserConfig.class).webDriverWait();
    }

    protected WebDriver getDriver() {
        return applicationContext.getBean(BrowserConfig.class).webDriver();
    }

    protected void visitBasePage() {
        getDriver().get("http://google.com.ua");
    }

    protected void visitUrl(final String url) {
        getDriver().get(url);
    }

    protected void clickOnElement(final By by) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        getDriver().findElement(by).click();
    }

    protected void setValue(final By by, final CharSequence... charSequences) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        getDriver().findElement(by).sendKeys(charSequences);
    }

    private boolean isElementsAreVisible(final List<WebElement> list) {
        try {
            getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(list));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOfElementByIndex(final List<WebElement> list, int index) {
        if (isElementsAreVisible(list)) {
            list.get(index).click();
        } else {
            throw new TimeoutException(String.format("List with size %d of web elements is not found by index: %d", list.size(), index));
        }
    }



    public String getTitle() {
        return getDriver().getTitle();
    }

}
