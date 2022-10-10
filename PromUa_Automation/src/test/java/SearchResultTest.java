import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultTest extends BaseTest {
    HomePage homePage;

    @Description("Check that during detailed search the search results are display relevant product cards with pictures, names and prices")
    @Test
    public void searchTest() {
        homePage = new HomePage(driver);
        homePage.enterValue("Детская панама");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://prom.ua/ua/search?search_term=%D0%94%D0%B5%D1%82%D1%81%D0%BA%D0%B0%D1%8F%20%D0%BF%D0%B0%D0%BD%D0%B0%D0%BC%D0%B0";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Description("Check search options with wrong keyboard layout")
    @Test
    public void searchWrongTest() {
        homePage = new HomePage(driver);
        homePage.enterValue("ltncrfz gfyfvf");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://prom.ua/ua/search?search_term=ltncrfz%20gfyfvf";
        Assert.assertEquals(actualUrl, expectedUrl);
    }


}
