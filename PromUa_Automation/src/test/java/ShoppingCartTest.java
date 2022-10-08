import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void testDisabledMinusButton() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        //scroll to often chosen elements block
        homePage.clickProduct();
        //wait shopping cart button and click on it
        homePage.getHeaderFragment().clickShoppingCartButton();
        //check decrease button
        Assert.assertFalse(driver.findElement(shoppingCartPage.decreaseProductAmountButton).isEnabled());
    }

    @Test
    public void testEnabledMinusButton() {
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        //scroll to often chosen elements block
        homePage.clickProduct();
        //wait shopping cart button and click on it
        homePage.getHeaderFragment().clickShoppingCartButton();
        //increase amount of product
        shoppingCartPage.increaseProductAmount();
        //check decrease button
        Assert.assertTrue(driver.findElement(shoppingCartPage.decreaseProductAmountButton).isEnabled());
    }
}