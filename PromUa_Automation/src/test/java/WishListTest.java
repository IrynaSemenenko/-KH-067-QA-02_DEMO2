import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest {
    WishListPage wishListPage;
    LoginPage loginPage;
    HomePage homePage;
    HeaderPage headerPage;

    @Test
    public void goToWishlist() {
        wishListPage = new WishListPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.authorizationWithFavoriteButton("irinabublik039@gmail.com", "Ib(0992163097)");
        Assert.assertTrue(wishListPage.nameWishListPageIsDisplayed());
    }

    @Test
    public void addProductsToWishlist() {
        wishListPage = new WishListPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        headerPage = new HeaderPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        homePage.clickFavoriteButtons();
        headerPage.clickFavoriteButton();
    }

    @Test
    public void shoppingButtonInWishList() {
        wishListPage = new WishListPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.authorizationWithFavoriteButton("irinabublik039@gmail.com", "Ib(0992163097)");
        wishListPage.nameWishListPageIsDisplayed();
        wishListPage.clickShoppingButton();
        String actualTitle  = driver.getTitle();
        String expectedTitle = "Prom.ua — маркетплейс Украины";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
