import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HeaderTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void checkMyPromButton() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickFavoriteButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        Assert.assertEquals(homePage.getHeaderFragment().myPromButton.getAttribute("href"), "https://my.prom.ua/uk/cabinet/user", "Href doesn't match current href");
    }

    @Test
    public void checkHelpButton() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickHelpButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getTitle(), "EVOService", "Title doesn't match current title");
    }

    @Test
    public void checkPromoPanel() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickPromoPanel();
        Assert.assertEquals(driver.getCurrentUrl(), "https://prom.ua/ua/sc/prom-oplata", "Url doesn't match current url");

    }

}



