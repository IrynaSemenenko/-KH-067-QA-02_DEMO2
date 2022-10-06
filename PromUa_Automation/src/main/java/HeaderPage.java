import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderPage extends BasePage{
    By singInButtonLocator = By.xpath("//button[@data-qaid='sign-in']");
    By favoriteButton = By.xpath("//button[@data-qaid='favorite_cabinet_button']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    public void clickFavoriteButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(favoriteButton))
                .click();
    }
    public void clickSingInButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(singInButtonLocator)).click();
    }
}
