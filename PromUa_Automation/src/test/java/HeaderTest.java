import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HeaderTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    @Description("Check that MyProm button leads to the personal account page")
    @Test
    public void checkMyPromButton() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickSingInButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        Assert.assertEquals(homePage.getHeaderFragment().getAttributeMyPromButton(), "https://my.prom.ua/uk/cabinet/user", "Href doesn't match current href");
    }

    @Description("Check that Help button leads to the following window")
    @Test
    public void checkHelpButton() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickHelpButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getTitle(), "EVOService", "Title doesn't match current title");
    }

    @Description("Check that Promo panel leades User with following URL")
    @Test
    public void checkPromoPanel() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickPromoPanel();
        Assert.assertEquals(driver.getCurrentUrl(), "https://prom.ua/ua/sc/prom-oplata", "Url doesn't match current url");

    }

}



