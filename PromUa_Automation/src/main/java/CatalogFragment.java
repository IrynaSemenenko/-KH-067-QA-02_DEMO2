import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogFragment extends BasePage{
    WebElement catalogPosition = driver.findElement(By.xpath("//a[@href='/ua/Krasota-i-zdorove'][1]"));
    WebElement catalogSubPosition = driver.findElement(By.xpath("//a[@href='/ua/Kosmetika-po-uhodu']"));
    WebElement catalogSubPosition1 = driver.findElement(By.xpath("//a[@href='/ua/Kosmeticheskie-sredstva-po-uhodu-za-kozhej-litsa']"));
    WebElement catalogSubPosition2 = driver.findElement(By.xpath("//a[@href='/ua/Maski-dlya-kozhi-litsa']"));
    WebElement catalogButton = driver.findElement(By.xpath("//span[@class='_3Trjq hJTsv']"));
    WebElement catalogListFromButton = driver.findElement(By.xpath("//div[@class='M3v0L cjswa sMgZR BXDW- IM66u yx1wK']"));
    WebElement catalogListFromHomePage = driver.findElement(By.xpath("//div[@class='M3v0L cjswa sMgZR BXDW- DUxBc IM66u yVZ7H']"));
    WebElement catalogPopupFirstLine = driver.findElement(By.xpath("//a[@href='/ua/sc/military'][1]"));
    WebElement catalogPopupLastLine = driver.findElement(By.xpath("//a[@href='/ua/kabanchik']"));
    public CatalogFragment(WebDriver driver) {
        super(driver);
    }

    public void openCatalogPosition(){
        wait.until(ExpectedConditions.visibilityOf(catalogPosition))
            .click();
    }
    public void openCatalogSubPosition(){
        wait.until(ExpectedConditions.visibilityOf(catalogSubPosition))
                .click();
    }
    public void openCatalogSubPosition1(){
        wait.until(ExpectedConditions.visibilityOf(catalogSubPosition1))
                .click();
    }
    public void openCatalogSubPosition2(){
        wait.until(ExpectedConditions.visibilityOf(catalogSubPosition2))
                .click();
    }
    public void catalogButtonClick(){
        wait.until(ExpectedConditions.visibilityOf(catalogButton))
            .click();
    }
    public void catalogPopupFromButtonScroll(){
        wait.until(ExpectedConditions.visibilityOf(catalogListFromButton));
        Actions actions = new Actions(driver);
        WebElement catalogPopupLastLine = driver.findElement(By.xpath("//a[@href='/ua/kabanchik']"));
        actions.scrollToElement(catalogPopupLastLine).perform();
    }
    public void findCatalogFirstLine(){
        wait.until(ExpectedConditions.visibilityOf(catalogPopupFirstLine));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogPopupFirstLine).perform();
    }
    public void catalogPopupFromHomePageScroll(){
        wait.until(ExpectedConditions.visibilityOf(catalogListFromHomePage));
        Actions actions = new Actions(driver);
        WebElement catalogPopupLastLine = driver.findElement(By.xpath("//a[@href='/ua/kabanchik']"));
        actions.scrollToElement(catalogPopupLastLine).perform();
    }
}
