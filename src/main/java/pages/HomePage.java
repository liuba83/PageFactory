package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[text()='women']")
    private WebElement womenButton;

    @FindBy(xpath = "//span[@class='topNavigation-sideNavTrigger-icon']")
    private WebElement navigationButton;

    @FindBy(xpath = "//div[@id='sidenav-infoLeftNode']")
    private WebElement helpAndInfoButton;

    @FindBy(xpath = "//div[contains(@id, 'sidenav-infoLeft')] //span[text() = 'Find a store']")
    private WebElement findStoreButton;

    public HomePage (WebDriver driver) {
        super (driver);
    }

    public void clickWomenButton() {
        womenButton.click();
    }

    public void clickNavigationButton() {
        navigationButton.click();
    }

    public void clickHelpAndInfoButton() {
        helpAndInfoButton.click();
    }

    public void clickFindStoreButton() {
        findStoreButton.click();
    }

}
