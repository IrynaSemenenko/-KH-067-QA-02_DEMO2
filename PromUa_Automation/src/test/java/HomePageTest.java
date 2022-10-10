import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    @Description("Check that component 'Знайти' is presented on Ukrainian version and component 'Найти' is presented on Russian version")
    @Test
    public void searchButtonOnMainPage() {
        homePage = new HomePage(driver);
        homePage.clickUaLanguageButton();
        homePage.wait.until(ExpectedConditions.titleContains("України"));
        By searchButtonLocator = By.xpath("//*[@data-qaid='search_btn']");;
        WebElement searchButton = driver.findElement(searchButtonLocator);
        Assert.assertEquals(searchButton.getText(), "Знайти");

        homePage.clickRuLanguageButton();
        homePage.wait.until(ExpectedConditions.titleContains("Украины"));
        searchButton = driver.findElement(searchButtonLocator);
        Assert.assertEquals(searchButton.getText(), "Найти");
    }
    @Description("Check that 'Каталог товаров' component is presented on the main page")
    @Test
    public void menuProductsOnMainPage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.menuProductsOnMainPageIsDisplayed());
    }
    @Description("Check that 'Сейчас покупают' component is presented on the main page")
    @Test
    public void seasonFeedOnMainPage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.seasonFeedOnMainPageIsDisplayed());
    }
    @Description("Check that 'Спеціально для вас' component is presented on the main page")
    @Test
    public void forYouOnMainPage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.forYouOnMainPageIsDisplayed());
    }
    @Description("Check that 'Пропозиція місяця' component is presented on the main page")
    @Test
    public void propozytsiyaMisyatsyaOnMainPage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.propozytsiyaMisyatsyaOnMainPageIsDisplayed());
    }
}
