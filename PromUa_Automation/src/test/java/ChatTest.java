import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChatTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Description("Check that if archived chats list is empty the message appears")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void checkArchiveButton() {
        homePage = new HomePage(driver);
        homePage.getChatFragment().clickChatButton();
        loginPage = new LoginPage(driver);
        loginPage.authorization("irinabublik039@gmail.com", "Ib(0992163097)");
        homePage.getChatFragment().clickChatCheckBox();
        homePage.getChatFragment().clickArchivedChats();
        Assert.assertTrue(homePage.getChatFragment().archivedChatListIsDisplayed());
    }
}
