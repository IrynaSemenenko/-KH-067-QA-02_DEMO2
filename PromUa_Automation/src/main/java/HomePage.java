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
    private ChatFragment chatFragment = new ChatFragment(driver);
    List<WebElement> favoriteButtons;
    List<WebElement> recommendedProducts;
    WebElement favoriteButton;
    WebElement product;
    WebElement titleForYou;
    WebElement searchField;
    WebElement menuProductsOnMainPage;
    WebElement seasonFeedOnMainPage;
    WebElement forYouOnMainPage;
    WebElement propozytsiyaMisyatsyaOnMainPage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click UA language button")
    public void clickUaLanguageButton() {
        By uaLanguageLocator = By.xpath("//*[@data-qaid='ua_lang']");
        WebElement languageButton = driver.findElement(uaLanguageLocator);
        languageButton.click();
    }

    @Step("Click RU language button")
    public void clickRuLanguageButton() {
        By ruLanguageLocator = By.xpath("//*[@data-qaid='ru_lang']");
        WebElement languageButton = driver.findElement(ruLanguageLocator);
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
    public List<WebElement> createListOfProducts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-qaid='buy-button']")));
        recommendedProducts = driver.findElements(By.xpath("//a[@data-qaid='buy-button']"));
        return recommendedProducts;
    }

    @Step("Scroll to product by index")
    public void scrollToProduct(int index, List<WebElement> list) {
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

    public ChatFragment getChatFragment() {
        return chatFragment;
    }

    @Step("Find the menu product on home page")
    public boolean menuProductsOnMainPageIsDisplayed() {
        By menuProductsLocator = By.xpath("//*[@data-qaid='menu_preview']");
        menuProductsOnMainPage = driver.findElement(menuProductsLocator);
        return wait.until(ExpectedConditions.visibilityOf(menuProductsOnMainPage))
                .isDisplayed();
    }

    @Step("Find the season feed on home page")
    public boolean seasonFeedOnMainPageIsDisplayed() {
        By seasonFeedLocator = By.xpath("//*[@data-qaid='menu_parent']");
        seasonFeedOnMainPage = driver.findElement(seasonFeedLocator);
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

    @Step("Enter value in the search field")
    public void enterValue(String value) {
        searchField = driver.findElement(By.name("search_term"));
        searchField.click();
        searchField.sendKeys(value);
        searchField.submit();

    }

    @Step("Find For You on home page")
    public boolean forYouOnMainPageIsDisplayed() {
        forYouOnMainPage = driver.findElement(By.className("l-GwW"));
        return wait.until(ExpectedConditions.visibilityOf(forYouOnMainPage))
                .isDisplayed();
    }

    @Step("Find '???????????????????? ????????????' on home page")
    public boolean propozytsiyaMisyatsyaOnMainPageIsDisplayed() {
        propozytsiyaMisyatsyaOnMainPage = driver.findElement(By.className("hXxo4"));
        return wait.until(ExpectedConditions.visibilityOf(propozytsiyaMisyatsyaOnMainPage))
                .isDisplayed();
    }
}


