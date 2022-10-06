import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    By emailButtonLocator = By.xpath("//div[@data-qaid='email_btn']");
    By emailFieldLocator = By.id("email_field");
    By submitEmailButtonLocator = By.id("emailConfirmButton");
    By passwordFieldLocator = By.id("enterPassword");
    By submitPasswordButtonLocator = By.id("enterPasswordConfirmButton");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickEmailButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailButtonLocator))
                .click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailFieldLocator))
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldLocator))
                .sendKeys(password);
    }

    public void clickSubmitEmailButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(submitEmailButtonLocator))
                .click();
    }

    public void clickSubmitPasswordButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(submitPasswordButtonLocator))
                .click();
    }
    public void authorizationWithFavoriteButton(String email, String password) { //favorite button in the header
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        headerPage.clickFavoriteButton();
        loginPage.clickEmailButton();
        loginPage.enterEmail(email);
        loginPage.clickSubmitEmailButton();
        loginPage.enterPassword(password);
        loginPage.clickSubmitPasswordButton();
    }
    public void authorization(String email, String password) {
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        headerPage.clickSingInButton();
        loginPage.clickEmailButton();
        loginPage.enterEmail(email);
        loginPage.clickSubmitEmailButton();
        loginPage.enterPassword(password);
        loginPage.clickSubmitPasswordButton();
    }
}
