package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage{

    @FindBy(xpath = "//p[@title='Slim Denim Overshirt']")
    private WebElement jacketPage;

    public ProductListPage (WebDriver driver) {
        super (driver);
    }

    public void clickJacketPage() {
        jacketPage.click();
    }
}
