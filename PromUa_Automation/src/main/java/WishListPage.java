import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Step("Find the name of wishlist page")
    public boolean nameWishListPageIsDisplayed() {
        nameWishListPage = driver.findElement(By.xpath("//span[@class='_3Trjq OAv5u']"));
        return wait.until(ExpectedConditions.visibilityOf(nameWishListPage)).isDisplayed();
    }

    @Step("Click on the shopping button in the wishlist")
    public void clickShoppingButton() {
        deleteButtons = driver.findElements(By.xpath("//span[@data-qaid='delete_icon']"));
        if (!deleteButtons.isEmpty()) {
            for (int i = 0; i < deleteButtons.size(); i++) {
                deleteButtons.get(i).click();
                deleteButtons.remove(i);
                i--;
            }
        }
        shoppingButton = driver.findElement(By.cssSelector(".UQrBM"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingButton)).click();
    }

    @Step("Get the count of added products from the wishlist")
    public String getCountAddedProduct() {
        addedProducts = driver.findElements(By.xpath("//a[@data-qaid='product_name']"));
        return String.valueOf(addedProducts.size());
    }

    @Step("Get the count of added products from the 'heart' icon in the header")
    public String getAttributeCounterFavorite() {
        counterFavorite = driver.findElement(By.xpath("//a[@data-qaid='comparison_btn']//span"));
        return counterFavorite.getText();
    }
}
