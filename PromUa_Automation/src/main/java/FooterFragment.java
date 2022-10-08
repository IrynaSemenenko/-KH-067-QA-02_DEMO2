import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterFragment extends BasePage{
    WebElement buyersHelpLink = driver.findElement(new By.ByXPath("//a[@href='https://help.prom.ua/hc/ru']"));
    WebElement sellersHelpLink = driver.findElement(new By.ByXPath("//a[@href='https://support.prom.ua/hc/ru']"));
    WebElement tariffsLink = driver.findElement(new By.ByXPath("//a[@href='https://my.prom.ua/ua/how_to_order']"));
    WebElement userAgreement = driver.findElement(new By.ByXPath( "//a[@href='/ua/terms-of-use']"));

    public FooterFragment(WebDriver driver) {
        super(driver);
    }

    public void clickBuyersHelpLink() {
        wait.until(ExpectedConditions.visibilityOf(buyersHelpLink)).click();
    }
    public void clickSellersHelpLink() {
        wait.until(ExpectedConditions.visibilityOf(sellersHelpLink)).click();
    }
    public void clickTariffsLink() {
        wait.until(ExpectedConditions.visibilityOf(tariffsLink)).click();
    }
    public void clickUserAgreement(){wait.until(ExpectedConditions.visibilityOf(userAgreement)).click();}
}