import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Description("Verify that password can be shown/encrypted by eye icon.")
    @Test
    public void checkPasswordEncryption() {
        homePage = new HomePage(driver);
        homePage.getHeaderFragment().clickSingInButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        homePage.getHeaderFragment().clickFavoriteButton();
        accountPage = new AccountPage(driver);
        accountPage.clickProfileSettingsButton();
        accountPage.clickLoginPasswordButton();
        accountPage.clickChangePasswordButton();
        accountPage.clearOldPasswordInput();
        accountPage.fillOldPasswordInput("Test");
        accountPage.verifyEncryptedPasswordIsPresent();
        accountPage.clickOldPasswordEyeIcon();
        accountPage.verifyShownPasswordIsPresent();
    }
}
