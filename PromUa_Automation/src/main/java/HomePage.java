import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    By favoriteButtons = By.xpath("//span[@data-qaid='add_favorite']");
    By favoriteButton = By.xpath("(//span[@data-qaid='add_favorite'])[3]");
    By product = By.xpath("(//a[@data-qaid='buy-button'])[1]");
    By titleForYou = By.xpath("(//div[@class='M3v0L YKUY6'])[2]");

    By searchButtonLocator = By.xpath("//*[@data-qaid='search_btn']");
    By ruLanguageLocator = By.xpath("//*[@data-qaid='ru_lang']");
    By uaLanguageLocator = By.xpath("//*[@data-qaid='ua_lang']");
    By menuProductsLocator = By.xpath("//*[@data-qaid='menu_preview']");
    By seasonFeedLocator = By.xpath("//*[@data-qaid='menu_parent']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLanguageButton(By languageLocator) {
        WebElement languageButton = driver.findElement(languageLocator);
        languageButton.click();
    }

    public void clickFavoriteButtons() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(titleForYou)).perform();
        System.out.println("Check 1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteButton));
        List<WebElement> listFavoriteButtons = driver.findElements(favoriteButtons);
        for (int i = 0; i < 3; i++) {
            listFavoriteButtons.get(i).click();
        }
    }

    public void clickProduct() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(titleForYou)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();
    }

}
