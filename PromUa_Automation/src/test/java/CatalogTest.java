import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest{
    HomePage homePage;
    CatalogFragment catalogFragment;
    @Description("Check that the Catalog categories can be opened")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void catalogCategoriesTest(){
        homePage = new HomePage(driver);
        catalogFragment = new CatalogFragment(driver);
        homePage.getCatalogFragment().openCatalogPosition();
        homePage.getCatalogFragment().openCatalogSubPosition();
        homePage.getCatalogFragment().openCatalogSubPosition1();
        homePage.getCatalogFragment().openCatalogSubPosition2();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://prom.ua/ua/Maski-dlya-kozhi-litsa";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
    @Description("Check that the Catalog Popup menu opened from the Catalog button can be scrolled down")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void catalogPopupFromButtonScrollTest(){
        homePage = new HomePage(driver);
        catalogFragment = new CatalogFragment(driver);
        homePage.getCatalogFragment().openCatalogPosition();
        homePage.getCatalogFragment().catalogButtonClick();
        homePage.getCatalogFragment().catalogPopupFromButtonScroll();
        homePage.getCatalogFragment().catalogPopupLastLine.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://prom.ua/ua/kabanchik";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
    @Description("Check that the Catalog Popup menu opened from the Home Page can be scrolled down")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void catalogPopupFromHomePageScroll(){
        homePage = new HomePage(driver);
        catalogFragment = new CatalogFragment(driver);
        homePage.getCatalogFragment().findCatalogFirstLine();
        homePage.getCatalogFragment().catalogPopupFromHomePageScroll();
        homePage.getCatalogFragment().catalogPopupLastLine.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://prom.ua/ua/kabanchik";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
