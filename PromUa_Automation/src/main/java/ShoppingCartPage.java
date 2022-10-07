import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartPage extends BasePage {
    By increaseProductAmountButton = By.xpath("//button[@data-testid='inc_btn']");
    By decreaseProductAmountButton = By.xpath("//button[@data-testid='dec_btn']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public void increaseProductAmount() {
        Actions actions = new Actions(driver);
        WebElement clickPlusButton = driver.findElement(increaseProductAmountButton);
        actions.click(clickPlusButton).click(clickPlusButton).click(clickPlusButton).perform();
    }
}
