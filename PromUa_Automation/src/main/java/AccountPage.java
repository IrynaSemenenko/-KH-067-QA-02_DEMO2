import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    By profileSettingsButton = By.xpath("//a[@href='/uk/cabinet/user/settings']");
    By loginPasswordButton = By.cssSelector("[data-qaid='credentials_settings_tab']");
    By changePasswordButton = By.cssSelector("[data-qaid='change_password_link']");
    By oldPasswordInput = By.cssSelector("[data-qaid='old_pass_input']");
    By oldPasswordEncrypted = By.cssSelector("[data-qaid='old_pass_input'][type='password']");
    By oldPasswordShown = By.cssSelector("[data-qaid='old_pass_input'][type='text']");
    By oldPasswordEyeIcon = By.cssSelector("[data-qaid='old_pass_input'] + .passwordInput__iconWrapp__nv58r7");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click profile settings button")
    public void clickProfileSettingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileSettingsButton))
                .click();
    }

    @Step("Click Login and Password button")
    public void clickLoginPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPasswordButton))
                .click();
    }

    @Step("Click Change password button")
    public void clickChangePasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordButton))
                .click();
    }

    @Step("Clear old password")
    public void clearOldPasswordInput() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(oldPasswordInput)).clear();
    }

    @Step("Fill old password")
    public void fillOldPasswordInput(String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(oldPasswordInput)).sendKeys(data);
    }

    @Step("Verify that encrypted password is present")
    public void verifyEncryptedPasswordIsPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(oldPasswordEncrypted));
    }

    @Step("Verify that shown password is present")
    public void verifyShownPasswordIsPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(oldPasswordShown));
    }

    @Step("Click on the old password eye icon")
    public void clickOldPasswordEyeIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(oldPasswordEyeIcon)).click();
    }
}
