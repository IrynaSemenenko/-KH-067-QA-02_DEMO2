import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WishListTest extends BaseTest {
    WishListPage wishListPage;
    LoginPage loginPage;
    HomePage homePage;

    @Description("Check that user can go to wishlist using the favorite button in the header as an unregistered user")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void goToWishlist() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickFavoriteButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        wishListPage = new WishListPage(driver);
        Assert.assertTrue(wishListPage.nameWishListPageIsDisplayed());
    }

    @Description("Check that the 'heart' icon in the header is displayed the correct numeric indicator of added items")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void addProductsToWishlist() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickSingInButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        homePage.clickFavoriteButtons();
        homePage.getHeaderFragment().clickFavoriteButton();
        wishListPage = new WishListPage(driver);
        String expectedResult = wishListPage.getCountAddedProduct();
        String actualResult = wishListPage.getAttributeCounterFavorite();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Description("Check that click on the 'За покупками' in the empty 'Бажане' page redirects to the main page")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void shoppingButtonInWishList() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickFavoriteButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        wishListPage = new WishListPage(driver);
        wishListPage.clickShoppingButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Prom.ua — маркетплейс України";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
