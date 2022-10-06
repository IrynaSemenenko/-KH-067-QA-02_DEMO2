import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@data-qaid='email_btn']")
    WebElement emailButton;
    @FindBy(id = "email_field")
    WebElement emailField;
    @FindBy(id = "emailConfirmButton")
    WebElement submitEmailButton;
    @FindBy(id = "enterPassword")
    WebElement passwordField;
    @FindBy(id = "enterPasswordConfirmButton")
    WebElement submitPasswordButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickEmailButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-qaid='email_btn']")))
                .click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_field")))
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("enterPassword")))
                .sendKeys(password);
    }

    public void clickSubmitEmailButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("emailConfirmButton")))
                .click();
    }

    public void clickSubmitPasswordButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("enterPasswordConfirmButton")))
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
