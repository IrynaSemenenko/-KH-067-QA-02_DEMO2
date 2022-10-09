import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest{
    HomePage homePage;
    CatalogFragment catalogFragment;
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
