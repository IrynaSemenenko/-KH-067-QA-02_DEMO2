import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishListPage extends BasePage{
    @FindBy(xpath = "//span[@class='_3Trjq OAv5u']")
    WebElement nameWishListPage;
    By shoppingButton = By.cssSelector(".uTnwV");
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    public boolean nameWishListPageIsDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='_3Trjq OAv5u']")))
                .isDisplayed();
    }
    public void clickShoppingButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingButton)).click();
    }
}
