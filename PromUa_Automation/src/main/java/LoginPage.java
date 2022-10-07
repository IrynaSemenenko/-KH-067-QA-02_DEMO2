import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    WebElement emailButton;
    WebElement emailField;
    WebElement submitEmailButton;
    WebElement passwordField;
    WebElement submitPasswordButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickEmailButton() {
        emailButton = driver.findElement(By.xpath("//div[@data-qaid='email_btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailButton))
                .click();
    }

    public void enterEmail(String email) {
        emailField = driver.findElement(By.id("email_field"));
        wait.until(ExpectedConditions.visibilityOf(emailField))
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField = driver.findElement(By.id("enterPassword"));
        wait.until(ExpectedConditions.visibilityOf(passwordField))
                .sendKeys(password);
    }

    public void clickSubmitEmailButton() {
        submitEmailButton = driver.findElement(By.id("emailConfirmButton"));
        wait.until(ExpectedConditions.elementToBeClickable(submitEmailButton))
                .click();
    }

    public void clickSubmitPasswordButton() {
        submitPasswordButton = driver.findElement(By.id("enterPasswordConfirmButton"));
        wait.until(ExpectedConditions.elementToBeClickable(submitPasswordButton))
                .click();
    }

    @Step("Authorization of the registered user")
    public void authorization(String email, String password) {
        clickEmailButton();
        enterEmail(email);
        clickSubmitEmailButton();
        enterPassword(password);
        clickSubmitPasswordButton();
    }
}
