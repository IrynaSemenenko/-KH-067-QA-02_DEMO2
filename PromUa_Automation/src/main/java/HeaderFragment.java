import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderFragment extends BasePage {
    WebElement favoriteButton;
    WebElement singInButton;
    WebElement myPromButton;
    WebElement helpButton;
    WebElement promoPanel;
    WebElement shoppingCartButton;

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void clickFavoriteButton() {
        favoriteButton = driver.findElement(By.xpath("//button[@data-qaid='favorite_cabinet_button']"));
        wait.until(ExpectedConditions.elementToBeClickable(favoriteButton))
                .click();
    }

    public void clickSingInButton() {
        singInButton = driver.findElement(By.xpath("//button[@data-qaid='sign-in']"));
        wait.until(ExpectedConditions.visibilityOf(singInButton)).click();
    }

    public void clickHelpButton() {
        helpButton = driver.findElement(By.xpath("//div/a[contains(@href, 'help.prom.ua')]"));
        wait.until(ExpectedConditions.elementToBeClickable(helpButton)).click();
    }

    public String getAttributeMyPromButton() {
        myPromButton = driver.findElement(By.xpath("//*[@id='page-block']/div/div[2]/div/div/div[2]/div[2]"));
        return wait.until(ExpectedConditions.elementToBeClickable(myPromButton)).getAttribute(("href"));
    }

    public void clickPromoPanel() {

        promoPanel = driver.findElement(By.xpath("//*[@id='page-block']/div/div[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(promoPanel)).click();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton = driver.findElement(By.xpath("//button[@data-qaid='shopping_cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
    }
}





