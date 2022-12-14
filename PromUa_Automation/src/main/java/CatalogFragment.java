import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogFragment extends BasePage{
    WebElement catalogPosition;
    WebElement catalogSubPosition;
    WebElement catalogSubPosition1;
    WebElement catalogSubPosition2;
    WebElement catalogButton;
    WebElement catalogListFromButton;
    WebElement catalogListFromHomePage;
    WebElement catalogPopupFirstLine;
    WebElement catalogPopupLastLine;
    public CatalogFragment(WebDriver driver) {
        super(driver);
    }

    @Step("Open Catalog category)")
    public void openCatalogPosition(){
        catalogPosition = driver.findElement(By.xpath("//a[@href='/ua/Krasota-i-zdorove'][1]"));
        wait.until(ExpectedConditions.visibilityOf(catalogPosition))
            .click();
    }
    @Step ("Open Catalog sub-category)")
    public void openCatalogSubPosition(){
        catalogSubPosition = driver.findElement(By.xpath("//a[@href='/ua/Kosmetika-po-uhodu']"));
        wait.until(ExpectedConditions.visibilityOf(catalogSubPosition))
                .click();
    }
    @Step ("Open Catalog sub-category(1)")
    public void openCatalogSubPosition1(){
        catalogSubPosition1 = driver.findElement(By.xpath("//a[@href='/ua/Kosmeticheskie-sredstva-po-uhodu-za-kozhej-litsa']"));
        wait.until(ExpectedConditions.visibilityOf(catalogSubPosition1))
                .click();
    }
    @Step ("Open Catalog sub-category(2)")
    public void openCatalogSubPosition2(){
        catalogSubPosition2 = driver.findElement(By.xpath("//a[@href='/ua/Maski-dlya-kozhi-litsa']"));
        wait.until(ExpectedConditions.visibilityOf(catalogSubPosition2))
                .click();
    }
    @Step ("Click the Catalog button")
    public void catalogButtonClick(){
        catalogButton = driver.findElement(By.xpath("//span[@class='_3Trjq hJTsv']"));
        wait.until(ExpectedConditions.visibilityOf(catalogButton))
            .click();
    }
    @Step ("Scroll the Catalog Popup")
    public void catalogPopupFromButtonScroll(){
        catalogListFromButton = driver.findElement(By.xpath("//div[@class='M3v0L cjswa sMgZR BXDW- IM66u yx1wK']"));
        wait.until(ExpectedConditions.visibilityOf(catalogListFromButton));
        Actions actions = new Actions(driver);
        catalogPopupLastLine = driver.findElement(By.xpath("//a[@href='/ua/kabanchik']"));
        actions.scrollToElement(catalogPopupLastLine).perform();
    }
    @Step ("Find the first line of Catalog List")
    public void findCatalogFirstLine(){
        catalogPopupFirstLine = driver.findElement(By.xpath("//a[@href='/ua/sc/military'][1]"));
        wait.until(ExpectedConditions.visibilityOf(catalogPopupFirstLine));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogPopupFirstLine).perform();
    }
    @Step ("Scroll the Catalog Popup")
    public void catalogPopupFromHomePageScroll(){
        catalogListFromHomePage = driver.findElement(By.xpath("//div[@class='M3v0L cjswa sMgZR BXDW- DUxBc IM66u yVZ7H']"));
        wait.until(ExpectedConditions.visibilityOf(catalogListFromHomePage));
        Actions actions = new Actions(driver);
        catalogPopupLastLine = driver.findElement(By.xpath("//a[@href='/ua/kabanchik']"));
        actions.scrollToElement(catalogPopupLastLine).perform();
    }
}
