package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage extends BasePage{

    private static final String JACKET_SIZE = "S";

    @FindBy(xpath = "//div[@class='product-actions']//button[@type='button']")
    private WebElement wishButton;

    @FindBy(xpath = "//b[@id='topNavigation-wishlistCount']")
    private WebElement wishButtonInHeader;

    @FindBy(xpath = "//div[@class='product-actions']//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//b[@id='topNavigation-bagCount']")
    private WebElement cartButtonInHeader;

    @FindBy(xpath = "//select[@title='size']")
    private WebElement sizeField;

    @FindBy(xpath = "//b[@id='topNavigation-bagCount']")
    private WebElement cartPopUp;

    @FindBy(xpath = "//button[@aria-pressed='true']")
    private WebElement heartButtonColored;

    public ProductDetailPage (WebDriver driver) {
        super (driver);
    }

    public void clickWishButton() {
        wishButton.click();
    }

    public String getNumberOfProductsInWishList() {
        return wishButtonInHeader.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getNumberOfProductsInCart() {
        return cartButtonInHeader.getText();
    }

    public void selectSize() {
        Select dropdown = new Select(sizeField);
        dropdown.selectByVisibleText(JACKET_SIZE);
    }

    public String getSelectedOption() {
        Select dropdown = new Select(sizeField);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        return selectedOption;
    }

    public WebElement getCartPopUp(){
        return cartPopUp;
    }

    public WebElement getHeartColor() {
        return heartButtonColored;
    }

}
