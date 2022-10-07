import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WishListPage extends BasePage {
    List<WebElement> deleteButtons;
    List<WebElement> addedProducts;
    WebElement shoppingButton;
    WebElement nameWishListPage;
    WebElement counterFavorite;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public boolean nameWishListPageIsDisplayed() {
        nameWishListPage = driver.findElement(By.xpath("//span[@class='_3Trjq OAv5u']"));
        return wait.until(ExpectedConditions.visibilityOf(nameWishListPage))
                .isDisplayed();
    }

    public void clickShoppingButton() {
        deleteButtons = driver.findElements(By.xpath("//span[@data-qaid='delete_icon']"));
        if (!deleteButtons.isEmpty()) {
            for (WebElement webElement : deleteButtons) {
                webElement.click();
            }
        }
        shoppingButton = driver.findElement(By.cssSelector(".uTnwV"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingButton)).click();
    }

    public String getCountAddedProduct() {
        addedProducts = driver.findElements(By.xpath("//a[@data-qaid='product_name']"));
        return String.valueOf(addedProducts.size());
    }

    public String getAttributeCounterFavorite() {
        counterFavorite = driver.findElement(By.xpath("//a[@data-qaid='comparison_btn']//span"));
        return counterFavorite.getText();
    }
}
