import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionalFunctionsOnMainPageTest extends BaseTest {

    private HomePage homePage;

    @Description("Check that component 'Знайти' is presented on Ukrainian version and component 'Найти' is presented on Russian version")
    @Test
    public void searchButtonOnMainPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLanguageButton(homePage.uaLanguageLocator);
        homePage.wait.until(ExpectedConditions.titleContains("України"));
        WebElement searchButton = driver.findElement(homePage.searchButtonLocator);
        Assert.assertEquals(searchButton.getText(), "Знайти");

        homePage.clickLanguageButton(homePage.ruLanguageLocator);
        homePage.wait.until(ExpectedConditions.titleContains("Украины"));
        searchButton = driver.findElement(homePage.searchButtonLocator);
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
}
