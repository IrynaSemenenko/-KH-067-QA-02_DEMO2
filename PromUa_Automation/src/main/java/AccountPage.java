import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    WebElement profileSettingsButton;
    WebElement loginPasswordButton;
    WebElement changePasswordButton;
    WebElement oldPasswordInput;
    WebElement oldPasswordEncrypted;
    WebElement oldPasswordShown;
    WebElement oldPasswordEyeIcon;
    WebElement nickNameInput;
    WebElement saveProfileButton;
    WebElement settingsSavedMessage;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click profile settings button")
    public void clickProfileSettingsButton() {
        profileSettingsButton = driver.findElement(By.xpath("//a[@href='/cabinet/user/settings']"));
        wait.until(ExpectedConditions.elementToBeClickable(profileSettingsButton))
                .click();
    }

    @Step("Click Login and Password button")
    public void clickLoginPasswordButton() {
        loginPasswordButton = driver.findElement(By.cssSelector("[data-qaid='credentials_settings_tab']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginPasswordButton))
                .click();
    }

    @Step("Click Change password button")
    public void clickChangePasswordButton() {
        changePasswordButton = driver.findElement(By.cssSelector("[data-qaid='change_password_link']"));
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordButton))
                .click();
    }

    @Step("Clear old password")
    public void clearOldPasswordInput() {
        oldPasswordInput = driver.findElement(By.cssSelector("[data-qaid='old_pass_input']"));
        wait.until(ExpectedConditions.visibilityOf(oldPasswordInput)).clear();
    }

    @Step("Fill old password")
    public void fillOldPasswordInput(String data) {
        oldPasswordInput = driver.findElement(By.cssSelector("[data-qaid='old_pass_input']"));
        wait.until(ExpectedConditions.visibilityOf(oldPasswordInput)).sendKeys(data);
    }

    @Step("Verify that encrypted password is present")
    public void verifyEncryptedPasswordIsPresent() {
        oldPasswordEncrypted = driver.findElement(By.cssSelector("[data-qaid='old_pass_input'][type='password']"));
        wait.until(ExpectedConditions.visibilityOf(oldPasswordEncrypted));
    }

    @Step("Verify that shown password is present")
    public boolean verifyShownPasswordIsPresent() {
        oldPasswordShown = driver.findElement(By.cssSelector("[data-qaid='old_pass_input'][type='text']"));
        return wait.until(ExpectedConditions.visibilityOf(oldPasswordShown)).isDisplayed();
    }

    @Step("Click on the old password eye icon")
    public void clickOldPasswordEyeIcon() {
        oldPasswordEyeIcon = driver.findElement(By.cssSelector("[data-qaid='old_pass_input'] + .passwordInput__iconWrapp__nv58r7"));
        wait.until(ExpectedConditions.elementToBeClickable(oldPasswordEyeIcon)).click();
    }

    @Step("Clear nickname")
    public void clearNicknameInput() {
        nickNameInput = driver.findElement(By.cssSelector("[data-qaid='nickname_input']"));
        wait.until(ExpectedConditions.visibilityOf(nickNameInput)).clear();
    }

    @Step("Fill nickname")
    public void fillNicknameInput(String nickname) {
        nickNameInput = driver.findElement(By.cssSelector("[data-qaid='nickname_input']"));
        wait.until(ExpectedConditions.visibilityOf(nickNameInput)).sendKeys(nickname);
    }

    @Step("Click Save profile button")
    public void clickSaveProfileButton() {
        Actions actions = new Actions(driver);
        saveProfileButton = driver.findElement(By.cssSelector("[data-qaid='save_profile']"));
        actions.scrollToElement(saveProfileButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(saveProfileButton))
                .click();
    }

    @Step("Verify that settings saved message is present")
    public boolean verifySettingsSavedMessageIsPresent() {
        settingsSavedMessage = driver.findElement(By.xpath("//p[text()='Настройки профиля успешно сохранены']"));
        return wait.until(ExpectedConditions.visibilityOf(settingsSavedMessage)).isDisplayed();
    }
}
