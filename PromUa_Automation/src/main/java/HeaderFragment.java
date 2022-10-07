import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderFragment extends BasePage {
    WebElement favoriteButton = driver.findElement(By.xpath("//button[@data-qaid='favorite_cabinet_button']"));
    WebElement singInButton = driver.findElement(By.xpath("//button[@data-qaid='sign-in']"));
    WebElement myPromButton = driver.findElement(By.xpath("//*[@id='page-block']/div/div[2]/div/div/div[2]/div[2]"));
    WebElement helpButton = driver.findElement(By.xpath("//*[@id='page-block']/div/div[2]/div/div/div[1]/div[3]/a"));
    WebElement promoPanel = driver.findElement(By.xpath("//*[@id='page-block']/div/div[1]"));

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void clickFavoriteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(favoriteButton))
                .click();
    }

    public void clickSingInButton() {
        wait.until(ExpectedConditions.visibilityOf(singInButton)).click();
    }

    public void clickHelpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(helpButton)).click();
    }

    public void clickPromoPanel() {
        wait.until(ExpectedConditions.elementToBeClickable(promoPanel)).click();
    }
}





