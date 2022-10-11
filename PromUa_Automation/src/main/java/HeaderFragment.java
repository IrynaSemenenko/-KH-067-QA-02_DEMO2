import io.qameta.allure.Step;
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
    WebElement ruLanguageButton;
    WebElement uaLanguageButton;

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    @Step("Click favorite button")
    public void clickFavoriteButton() {
        favoriteButton = driver.findElement(By.xpath("//button[@data-qaid='favorite_cabinet_button']"));
        wait.until(ExpectedConditions.elementToBeClickable(favoriteButton)).click();
    }

    @Step("Click sign in button")
    public void clickSingInButton() {
        singInButton = driver.findElement(By.xpath("//button[@data-qaid='sign-in']"));
        wait.until(ExpectedConditions.visibilityOf(singInButton)).click();
    }

    @Step("Click help button")
    public void clickHelpButton() {
        helpButton = driver.findElement(By.xpath("//div/a[contains(@href, 'help.prom.ua')]"));
        wait.until(ExpectedConditions.elementToBeClickable(helpButton)).click();
    }

    @Step("Get attribute of MyProm button")
    public String getAttributeMyPromButton() {
        myPromButton = driver.findElement(By.xpath("//button[@data-qaid='menu_btn']"));
        return wait.until(ExpectedConditions.elementToBeClickable(myPromButton)).getAttribute(("href"));
    }

    @Step("Click promo panel")
    public void clickPromoPanel() {
        promoPanel = driver.findElement(By.xpath("//div[@data-qaid='promo_panel']"));
        wait.until(ExpectedConditions.elementToBeClickable(promoPanel)).click();
    }

    @Step("Click shopping cart button on the home page")
    public void clickShoppingCartButton() {
        shoppingCartButton = driver.findElement(By.xpath("//button[@data-qaid='shopping_cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        shoppingCartButton.click();
    }

    @Step("Get Text on the 'SignIn' Button")
    public String getTextSignInButton() {
        singInButton = driver.findElement(By.xpath("//button[@data-qaid='sign-in']"));
        return wait.until(ExpectedConditions.elementToBeClickable(singInButton)).getText();
    }

    @Step("Click on the 'ru' Button")
    public void clickRuButton() {
        ruLanguageButton = driver.findElement(By.xpath("//*[@data-qaid='ru_lang']"));
        wait.until(ExpectedConditions.visibilityOf(ruLanguageButton)).click();
    }

    @Step("Click on the 'UA' Button")
    public void clickUaButton() {
        uaLanguageButton = driver.findElement(By.xpath("//*[@data-qaid='ua_lang']"));
        wait.until(ExpectedConditions.visibilityOf(uaLanguageButton)).click();
    }
}






