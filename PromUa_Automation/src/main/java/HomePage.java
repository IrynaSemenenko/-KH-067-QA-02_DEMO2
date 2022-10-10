import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    private HeaderFragment headerFragment = new HeaderFragment(driver);
    private FooterFragment footerFragment = new FooterFragment(driver);
    private CatalogFragment catalogFragment = new CatalogFragment(driver);
    List<WebElement> favoriteButtons;
    List<WebElement> recommendedProducts;
    WebElement favoriteButton;
    WebElement product;
    WebElement titleForYou;

    By searchButtonLocator = By.xpath("//*[@data-qaid='search_btn']");
    By ruLanguageLocator = By.xpath("//*[@data-qaid='ru_lang']");
    By uaLanguageLocator = By.xpath("//*[@data-qaid='ua_lang']");
    By menuProductsLocator = By.xpath("//*[@data-qaid='menu_preview']");
    By seasonFeedLocator = By.xpath("//*[@data-qaid='menu_parent']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click language button")
    public void clickLanguageButton(By languageLocator) {
        WebElement languageButton = driver.findElement(languageLocator);
        languageButton.click();
    }

    @Step("Add several products to the wishlist")
    public void clickFavoriteButtons() {
        Actions actions = new Actions(driver);
        titleForYou = driver.findElement(By.xpath("(//div[@class='M3v0L YKUY6'])[2]"));
        actions.scrollToElement(titleForYou).perform();
        favoriteButtons = driver.findElements(By.xpath("//span[@data-qaid='add_favorite']"));
        favoriteButton = driver.findElement(By.xpath("(//span[@data-qaid='add_favorite'])[3]"));
        wait.until(ExpectedConditions.visibilityOf(favoriteButton));
        List<WebElement> listFavoriteButtons = favoriteButtons;
        for (int i = 0; i < 3; i++) {
            listFavoriteButtons.get(i).click();
        }
    }
    @Step("Scroll to recommendation block")
    public void scrollToRecommendation() {
        Actions actions = new Actions(driver);
        titleForYou = driver.findElement(By.xpath("(//div[@class='M3v0L YKUY6'])[2]"));
        actions.scrollToElement(titleForYou).perform();
    }
    @Step("Add first product from recommendation block to the cart")
    public void clickOnFirstRecommendedProduct() {
        product = driver.findElement(By.xpath("(//a[@data-qaid='buy-button'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(product)).click();
    }
    @Step("Create list of products from recommendation block")
    public List<WebElement> createListOfProducts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qaid='buy-button']")));
        recommendedProducts = driver.findElements(By.xpath("//a[@data-qaid='buy-button']"));
        return recommendedProducts;
    }
    @Step("Scroll to product by index")
    public void scrollToProduct(int index, List<WebElement> list){
        Actions actions = new Actions(driver);
        actions.scrollToElement(list.get(index)).perform();
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

    @Step("Find the menu product on home page")
    public boolean menuProductsOnMainPageIsDisplayed() {
        WebElement menuProductsOnMainPage = driver.findElement(menuProductsLocator);
        return wait.until(ExpectedConditions.visibilityOf(menuProductsOnMainPage))
                .isDisplayed();
    }

    @Step("Find the season feed on home page")
    public boolean seasonFeedOnMainPageIsDisplayed() {
        WebElement seasonFeedOnMainPage = driver.findElement(seasonFeedLocator);
        return wait.until(ExpectedConditions.visibilityOf(seasonFeedOnMainPage))
                .isDisplayed();
    }

    @Step("Click on product title")
    public void clickOnProductTitle() {
        Actions actions = new Actions(driver);
        titleForYou = driver.findElement(By.xpath("(//div[@class='M3v0L YKUY6'])[2]"));
        actions.scrollToElement(titleForYou).perform();
        WebElement titleProduct = driver.findElement(By.xpath("(//div[@class='M3v0L -pUjB VrlHh']/a)[1]"));
        wait.until(ExpectedConditions.visibilityOf(titleProduct)).click();
    }
}

