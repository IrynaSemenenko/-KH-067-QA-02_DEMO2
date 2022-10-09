import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    private HeaderFragment headerFragment = new HeaderFragment(driver);
    private FooterFragment footerFragment = new FooterFragment(driver);
    private CatalogFragment catalogFragment = new CatalogFragment(driver);
    List<WebElement> favoriteButtons;
    WebElement favoriteButton;
    WebElement product;
    WebElement titleForYou = driver.findElement(By.xpath("(//div[@class='M3v0L YKUY6'])[2]"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Add several products to the wishlist")
    public void clickFavoriteButtons() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(titleForYou).perform();
        favoriteButtons = driver.findElements(By.xpath("//span[@data-qaid='add_favorite']"));
        favoriteButton = driver.findElement(By.xpath("(//span[@data-qaid='add_favorite'])[3]"));
        wait.until(ExpectedConditions.visibilityOf(favoriteButton));
        List<WebElement> listFavoriteButtons = favoriteButtons;
        for (int i = 0; i < 3; i++) {
            listFavoriteButtons.get(i).click();
        }
    }

    @Step("Add product to the cart")
    public void clickProduct() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(titleForYou).perform();
        product = driver.findElement(By.xpath("(//a[@data-qaid='buy-button'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(product)).click();
    }

    public HeaderFragment getHeaderFragment() {
        return headerFragment;
    }

    public FooterFragment getFooterFragment() {
        return footerFragment;
    }
    public CatalogFragment getCatalogFragment() {
        return catalogFragment;
    }
}
