package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.FindStorePage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductListPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String GSTAR_URL = "https://www.g-star.com/en_us";


    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
       driver.set(new RemoteWebDriver(new URL("http://10.0.0.168:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
       getDriver().manage().window().maximize();
       getDriver().get(GSTAR_URL);
   }

  @AfterMethod
   public void tearDown() {
       getDriver().close();
   }

   @AfterClass
   void terminate() {
       driver.remove();
   }

   public WebDriver getDriver() {
       return driver.get();
   }

   public HomePage getHomePage() {
      return new HomePage(getDriver());
   }

   public ProductListPage getProductListPage() {
       return new ProductListPage(getDriver());
   }

   public ProductDetailPage getProductDetailPage() {
       return new ProductDetailPage(getDriver());
   }

   public FindStorePage getFindStorePage() {
       return new FindStorePage(getDriver());
   }
}
