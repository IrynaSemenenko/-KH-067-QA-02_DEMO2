import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    String textWholeSale;
    WebElement increaseProductAmountButton;
    WebElement decreaseProductAmountButton;
    WebElement wholesalePriceButton;
    WebElement deleteButton;
    WebElement changeAmountField;
    WebElement exitToHomePageButton;
    WebElement forTheShopping;
    List<WebElement> deleteButtons;
    By decreaseProductAmountLocator = By.xpath("//button[@data-testid='dec_btn']");
    By wholesalePriceLocator = By.xpath("//button[@data-testid='add_btn']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Increase product amount to 3 pieces")
    public void increaseProductAmount() {
        Actions actions = new Actions(driver);
        increaseProductAmountButton = driver.findElement(By.xpath("//button[@data-testid='inc_btn']"));
        decreaseProductAmountButton = driver.findElement(By.xpath("//button[@data-testid='dec_btn']"));
        actions.click(increaseProductAmountButton).click(increaseProductAmountButton).click(increaseProductAmountButton).perform();
    }

    @Step("Clear and enter 0 into amount field")
    public void changeAmountToZero() {
        changeAmountField = driver.findElement(By.xpath("//input[@data-testid='input']"));
        changeAmountField.clear();
        changeAmountField.sendKeys("0");
        wait.until(ExpectedConditions.attributeToBe(changeAmountField, "value", "1"));
    }

    @Step("Click on exit to main menu button")
    public void clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='back_btn']")));
        exitToHomePageButton = driver.findElement(By.xpath("//button[@data-testid='back_btn']"));
        exitToHomePageButton.click();
    }

    @Step("Create list of delete buttons of products")
    public List<WebElement> createListOfDeleteButtons() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='remove_btn']")));
        deleteButtons = driver.findElements(By.xpath("//button[@data-testid='remove_btn']"));
        return deleteButtons;
    }

    @Step("Get text wholesale")
    public String getWholesaleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='wholesale_alert']")));
        textWholeSale = driver.findElement(By.xpath("//span[@data-testid='wholesale_alert']")).getText();
        wholesalePriceButton = driver.findElement(wholesalePriceLocator);
        wholesalePriceButton.click();
        deleteButton = driver.findElement(By.xpath("//button[@data-testid='remove_btn']"));
        deleteButton.click();
        return textWholeSale;
    }
}
