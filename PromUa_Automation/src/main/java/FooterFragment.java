import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterFragment extends BasePage{
    WebElement buyersHelpLink;
    WebElement sellersHelpLink;
    WebElement tariffsLink;
    WebElement userAgreement;
    WebElement youTubeButton;
    WebElement changeThemeButton;

    public FooterFragment(WebDriver driver) {
        super(driver);
    }

    public void clickBuyersHelpLink() {
        buyersHelpLink = driver.findElement(By.xpath("//a[@href='https://help.prom.ua/hc/ru']"));
        wait.until(ExpectedConditions.visibilityOf(buyersHelpLink)).click();
    }
    public void clickSellersHelpLink() {
        sellersHelpLink = driver.findElement(By.xpath("//a[@href='https://support.prom.ua/hc/ru']"));
        wait.until(ExpectedConditions.visibilityOf(sellersHelpLink)).click();
    }
    public void clickTariffsLink() {
        tariffsLink = driver.findElement(By.xpath("//a[@href='https://my.prom.ua/ua/how_to_order']"));
        wait.until(ExpectedConditions.visibilityOf(tariffsLink)).click();
    }
    public void clickUserAgreement(){
        userAgreement = driver.findElement(By.xpath("//a[@href='/ua/terms-of-use']"));
        wait.until(ExpectedConditions.visibilityOf(userAgreement)).click();
    }
    public  void clickYoutubeButton(){
        youTubeButton = driver.findElement(By.xpath("//*[@clip-path='url(#Youtube__a)']"));
        wait.until(ExpectedConditions.elementToBeClickable(youTubeButton)).click();
    }
    public void clickChangeTheme(){
        changeThemeButton = driver.findElement(By.xpath("//button[@class='_0cNvO _0YfIB jwtUM']"));
        wait.until(ExpectedConditions.elementToBeClickable(changeThemeButton)).click();
    }
    public String getTitleChangeTheme(){
        changeThemeButton = driver.findElement(By.xpath("//button[@class='_0cNvO _0YfIB jwtUM']"));
        return changeThemeButton.getAttribute("title");
    }
}
