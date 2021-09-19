package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GstarTest extends BaseTest {

    private static final String SELECTED_SIZE = "S";
    private static final String NUMBER_IN_WISHLIST = "1";
    private static final String NUMBER_IN_CART = "1";
    private static final String SEARCH_FIELD_FOR_STORE = "California 94118";
    private static final int EXPECTED_NUMBER_OF_STORES = 4;
    private static final long WAITING_TIME = 30;

    @FindBy(xpath = "")
    private WebElement expectedElement;


   @Test
    public void verifyAddToWishlist() {
        getHomePage().clickWomenButton();
        getProductListPage().clickJacketPage();
        getProductDetailPage().clickWishButton();
        getHomePage().waitVisibilityOfElement(WAITING_TIME, getProductDetailPage().getHeartColor());
        assertEquals(getProductDetailPage().getNumberOfProductsInWishList(), NUMBER_IN_WISHLIST);
    }

    @Test
    public void verifyAddToCart() {
       getHomePage().clickWomenButton();
       getProductListPage().clickJacketPage();
       getProductDetailPage().selectSize();
       assertEquals(getProductDetailPage().getSelectedOption(), SELECTED_SIZE);
       getProductDetailPage().clickAddToCartButton();
       getHomePage().waitVisibilityOfElement(WAITING_TIME, getProductDetailPage().getCartPopUp());
       assertEquals(getProductDetailPage().getNumberOfProductsInCart(), NUMBER_IN_CART);
    }

    @Test
    public void verifyFindStore() {
       getHomePage().clickHelpAndInfoButton();
       getHomePage().clickFindStoreButton();
       getFindStorePage().clickSearchField();
       getFindStorePage().enterZipAndState(SEARCH_FIELD_FOR_STORE);
       getHomePage().waitVisibilityOfElement(WAITING_TIME, getFindStorePage().getVisibleStore());
       assertEquals(getFindStorePage().getActualElementSize(), EXPECTED_NUMBER_OF_STORES);
    }

}
