import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasePage{
    WebElement getAll;
    public GooglePage(WebDriver driver) {
        super(driver);
    }
    public void clickGetAll(){
        getAll = driver.findElement(By.xpath("(//button[@data-idom-class='nCP5yc AjY5Oe DuMIQc LQeN7 IIdkle'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(getAll)).click();

    }
}

