import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private SellerContactFragment sellerContactFragment = new SellerContactFragment(driver);
    WebElement buttonSellerContact;
    WebElement buttonAllDescription;
    WebElement openDescription;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Seller contact")
    public void clickOnSellerContact() {
        buttonSellerContact = driver.findElement(By.xpath("//button[@data-qaid='company_contacts']"));
        wait.until(ExpectedConditions.visibilityOf(buttonSellerContact)).click();
    }

    @Step("Click on button all description")
    public void clickOnButtonAllDescription() {
        buttonAllDescription = driver.findElement(By.xpath("//button[@data-qaid='all_descriptions']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonAllDescription)).click();
    }

    @Step("Get Seller contact fragment")
    public SellerContactFragment getSellerContactFragment() {
        return sellerContactFragment;
    }

    @Step("Open description is displayed")
    public boolean openDescriptionIsDisplayed() {
        openDescription = driver.findElement(By.xpath("//div[@class='PSBDU B4D0A']"));
        return openDescription.isDisplayed();
    }
}