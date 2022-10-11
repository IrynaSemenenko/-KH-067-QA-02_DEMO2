import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChatTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Description("Check that MyProm button leads to the personal account page")
    @Test
    public void checkMyPromButton() {
        homePage = new HomePage(driver);
        homePage.getChatFragment().clickChatButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        homePage.getChatFragment().clickChatCheckBox();
        homePage.getChatFragment().clickArchivedChats();
        Assert.assertTrue(homePage.getChatFragment().archivedChatListIsDisplayed());
    }

}
