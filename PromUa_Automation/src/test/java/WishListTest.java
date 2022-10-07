import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WishListTest extends BaseTest {
    WishListPage wishListPage;
    LoginPage loginPage;
    HomePage homePage;


    @Test
    public void goToWishlist() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickFavoriteButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        wishListPage = new WishListPage(driver);
        Assert.assertTrue(wishListPage.nameWishListPageIsDisplayed());
    }

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

    @Test
    public void shoppingButtonInWishList() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickFavoriteButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        wishListPage = new WishListPage(driver);
        wishListPage.nameWishListPageIsDisplayed();
        wishListPage.clickShoppingButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Prom.ua — маркетплейс України";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
