import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductPageTest extends BaseTest {
    ProductPage productPage;
    HomePage homePage;

    @Description("Check that the contact of Sellers is open")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void buttonOpenContactSeller() {
        homePage = new HomePage(driver);
        homePage.clickOnProductTitle();
        productPage = new ProductPage(driver);
        productPage.clickOnSellerContact();
        Assert.assertEquals(productPage.getSellerContactFragment().getTitleContact(), "Контакти");
    }

    @Description("Check that all description of product is open")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void checkButtonAllDescription() {
        homePage = new HomePage(driver);
        homePage.clickOnProductTitle();
        productPage = new ProductPage(driver);
        productPage.clickOnButtonAllDescription();
        Assert.assertTrue(productPage.openDescriptionIsDisplayed());
    }
}