import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest{
    FooterPage footerPage;


    @Test
    public void goToBuyersHelpLink() {
        footerPage = new FooterPage(driver);
        footerPage.clickBuyersHelpLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://help.prom.ua/hc/ru";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void goToSellersHelpLink() {
        footerPage = new FooterPage(driver);
        footerPage.clickSellersHelpLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://support.prom.ua/hc/ru";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void goToTariffsLink() {
        footerPage = new FooterPage(driver);
        footerPage.clickTariffsLink();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://my.prom.ua/ua/how_to_order";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
