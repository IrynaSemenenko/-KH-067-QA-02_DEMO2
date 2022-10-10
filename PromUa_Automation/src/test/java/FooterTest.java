import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {
    HomePage homePage;
    GooglePage googlePage;

    @Description("Check that 'Довідка для покупців' link leads to page with popular questions for buyers")
    @Test
    public void goToBuyersHelpLink() {
        homePage = new HomePage(driver);
        homePage.getFooterFragment().clickBuyersHelpLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://help.prom.ua/hc/ru";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Description("Check that 'Довідка для продавців' link leads to page with popular questions for sellers")
    @Test
    public void goToSellersHelpLink() {
        homePage = new HomePage(driver);
        homePage.getFooterFragment().clickSellersHelpLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://support.prom.ua/hc/ru";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Description("Check that tariffs link leads to page with tariffs")
    @Test
    public void goToTariffsLink() {
        homePage = new HomePage(driver);
        homePage.getFooterFragment().clickTariffsLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://my.prom.ua/ua/how_to_order";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Description("Check that User agreement button leads to page with terms of use")
    @Test
    public void goToUserAgreement() {
        homePage = new HomePage(driver);
        homePage.getFooterFragment().clickUserAgreement();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://prom.ua/ua/terms-of-use";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Description("Check that User can move on the YouTube channel")
    @Test
    public void goToYouTubeChannel() {
        homePage = new HomePage(driver);
        homePage.getFooterFragment().clickYoutubeButton();
        googlePage = new GooglePage(driver);
        googlePage.clickGetAll();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/prom4ua");
    }

    @Description("Check that theme Button is changed")
    @Test
    public void changeTheme() {
        homePage = new HomePage(driver);
        homePage.getFooterFragment().clickChangeTheme();
        Assert.assertEquals(homePage.getFooterFragment().getTitleChangeTheme(), "Вимкнути темну тему");
    }
}
