import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class LogInTest extends BaseTest {
        HomePage homePage;


        @Description("Check that  'Увійти' button  is displayed on the  Ukrainian version of the website")
        @Test
        public void logInButtonPresenceUKR() {
            HomePage homePage = new HomePage(driver);
            homePage.clickLanguageButton(homePage.uaLanguageLocator);
            homePage.wait.until(ExpectedConditions.titleContains("України"));
            WebElement signInButton = driver.findElement(homePage.signInButtonLocator);
            Assert.assertEquals(signInButton.getText(), "Увійти");
        }

        @Description("Check that 'Bойти' button is displayed on Russian version of the website")
        @Test
        public void logInButtonPresenceRUS() {
            homePage.clickLanguageButton(homePage.ruLanguageLocator);
            homePage.wait.until(ExpectedConditions.titleContains("Украины"));
            WebElement signInButton = driver.findElement(homePage.signInButtonLocator);
            Assert.assertEquals(signInButton.getText(), "Войти");
        }

        @Description("Check that clicking on the 'Увійти' button leads to the displaying 'Увійти в кабінет' tab")
        @Test
        public void logInButtonLink() {
            homePage = new HomePage(driver);
            homePage.clicksignInButton(homePage.signInButtonLocator);
            String actualUrl = "https://prom.ua/ua/?source=header";
            String expectedUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl, actualUrl);
            if (actualUrl.equalsIgnoreCase(expectedUrl)) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }
    }
