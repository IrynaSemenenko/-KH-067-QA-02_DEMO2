import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Description("Check that 'Bойти' button is displayed on Russian version of the website")
    @Test
    public void logInButtonPresenceRus() {
        homePage = new HomePage(driver);
        homePage.clickLanguageButton(homePage.ruLanguageLocator);
        Assert.assertEquals(homePage.getHeaderFragment().getTextSignInButton(), "Войти");
    }

    @Description("Check that  'Увійти' button  is displayed on the  Ukrainian version of the website")
    @Test
    public void logInButtonPresenceUa() {
        homePage = new HomePage(driver);
        homePage.clickLanguageButton(homePage.ruLanguageLocator);
        homePage.clickLanguageButton(homePage.uaLanguageLocator);
        Assert.assertEquals(homePage.getHeaderFragment().getTextSignInButton(), "Увійти");
    }

    @Description("Check that an unthorized user can sign in using the 'Sign in' button")
    @Test
    public void authorizationUser() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickSingInButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        Assert.assertEquals(driver.getCurrentUrl(), "https://prom.ua/ua/?source=header");
    }
}
