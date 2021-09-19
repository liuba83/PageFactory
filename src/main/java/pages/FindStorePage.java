package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindStorePage extends BasePage {

    @FindBy(xpath = "//input[@id='location']")
    private WebElement searchField;

    @FindBy(xpath = "//li[contains(@class, 'storeFinder-bar-list-item')]")
    List<WebElement> elementList;

    @FindBy(xpath = "//li[@data-store-id='10fc71fc-2d1b-4707-86d3-59dcfb1fdcdd']")
    private WebElement visibleStore;

    public  FindStorePage (WebDriver driver) {
        super (driver);
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void enterZipAndState (final String searchText) {
        searchField.sendKeys(searchText, Keys.ENTER);
    }

    public int getActualElementSize() {
        int actualElementSize = elementList.size();
        return actualElementSize;
    }

    public WebElement getVisibleStore() {
        return visibleStore;
    }

}
