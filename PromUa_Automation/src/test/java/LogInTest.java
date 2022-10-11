import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Description("Check that 'Bойти' button is displayed on Russian version of the website")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void logInButtonPresenceRus() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickRuButton();
        Assert.assertEquals(homePage.getHeaderFragment().getTextSignInButton(), "Войти");
    }

    @Description("Check that  'Увійти' button  is displayed on the  Ukrainian version of the website")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void logInButtonPresenceUa() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickRuButton();
        homePage.getHeaderFragment().clickUaButton();
        Assert.assertEquals(homePage.getHeaderFragment().getTextSignInButton(), "Увійти");
    }

    @Description("Check that an authorized user can sign in using the 'Sign in' button")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void authorizationUser() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickSingInButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        Assert.assertEquals(driver.getCurrentUrl(), "https://prom.ua/ua/?source=header");
    }
}
