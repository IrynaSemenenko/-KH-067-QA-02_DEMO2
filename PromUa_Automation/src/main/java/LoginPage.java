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

    @Step("Click on the email button")
    public void clickEmailButton() {
        emailButton = driver.findElement(By.xpath("//div[@data-qaid='email_btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailButton))
                .click();
    }

    @Step("Enter value to the email field")
    public void enterEmail(String email) {
        emailField = driver.findElement(By.id("email_field"));
        wait.until(ExpectedConditions.visibilityOf(emailField))
                .sendKeys(email);
    }

    @Step("Enter value to the password field")
    public void enterPassword(String password) {
        passwordField = driver.findElement(By.id("enterPassword"));
        wait.until(ExpectedConditions.visibilityOf(passwordField))
                .sendKeys(password);
    }

    @Step("Click on the email button")
    public void clickSubmitEmailButton() {
        submitEmailButton = driver.findElement(By.id("emailConfirmButton"));
        wait.until(ExpectedConditions.elementToBeClickable(submitEmailButton))
                .click();
    }

    @Step("Click on the password button")
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
