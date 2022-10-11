import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;

    @Description("Test disabled decrease button for amount of product equal 1 in the shopping cart")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testDisabledMinusButton() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.scrollToRecommendation();
        homePage.clickOnFirstRecommendedProduct();
        homePage.getHeaderFragment().clickShoppingCartButton();
        Assert.assertFalse(driver.findElement(shoppingCartPage.decreaseProductAmountLocator).isEnabled());
    }

    @Description("Test decrease button for amount of product more than 1 in the shopping cart")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testEnabledMinusButton() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.scrollToRecommendation();
        homePage.clickOnFirstRecommendedProduct();
        homePage.getHeaderFragment().clickShoppingCartButton();
        shoppingCartPage.increaseProductAmount();
        Assert.assertTrue(shoppingCartPage.decreaseProductAmountButton.isEnabled());}

    @Description("Check return '1' after input '0' into amount of product field")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void checkZeroInputAmountField() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.scrollToRecommendation();
        homePage.clickOnFirstRecommendedProduct();
        shoppingCartPage.changeAmountToZero();
        Assert.assertEquals(shoppingCartPage.changeAmountField.getAttribute("value"), "1");}

    @Description("Check appearance 'go for the shopping' button after delete products from the shopping cart ")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testReturnToShoppingButton() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.scrollToRecommendation();
        for (int i = 0; i < 3; i++) {
            homePage.createListOfProducts().get(i).click();
            if (i < 2) {
                shoppingCartPage.clickExitButton();}
        }
        for (WebElement list : shoppingCartPage.createListOfDeleteButtons()) {
            list.click();
        }
        shoppingCartPage.forTheShopping = driver.findElement
                (By.xpath("//button[@data-testid='return_to_shopping_btn']"));
        Assert.assertTrue(shoppingCartPage.forTheShopping.isEnabled());}

    @Description("Check wholesale option button")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkWholesaleButton() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.scrollToRecommendation();
        homePage.createListOfProducts();
        int indexOfProduct = 0;
        boolean check = true;
        while (check) {
            homePage.scrollToProduct(indexOfProduct, homePage.recommendedProducts);
            homePage.recommendedProducts.get(indexOfProduct).click();
            if (driver.findElements(shoppingCartPage.wholesalePriceLocator).isEmpty()) {
                shoppingCartPage.createListOfDeleteButtons().get(0).click();
                shoppingCartPage.clickExitButton();
                indexOfProduct = indexOfProduct + 2;
            } else {
                shoppingCartPage.textWholeSale = shoppingCartPage.getWholesaleText();
                check = false;
            }
        }
        String textAmount = driver.findElement(By.xpath("//input[@data-testid='input']")).getAttribute("value") + " шт";
        Assert.assertTrue(shoppingCartPage.textWholeSale.contains(textAmount));
    }
}
