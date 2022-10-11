import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


    public class ChatFragment extends BasePage {

        public ChatFragment(WebDriver driver) {
            super(driver);
        }
        WebElement chatButton;
        WebElement chatCheckBox;
        WebElement archivedChats;
        WebElement chatEmptyMessage;


        @Step("Click chat button")
        public void clickChatButton() {
            chatButton = driver.findElement(By.xpath("//div[@data-qaid='besida_tool_block']"));
            wait.until(ExpectedConditions.elementToBeClickable(chatButton)).click();
        }

        @Step("Click chat checkbox button")
        public void clickChatCheckBox() {
            chatCheckBox = driver.findElement(By.xpath("//div[@class='besida-dropdown__root--p4uAJ']"));
            wait.until(ExpectedConditions.elementToBeClickable(chatCheckBox)).click();
        }

        @Step("Open archived chats")
        public void clickArchivedChats() {
            archivedChats = driver.findElement(By.xpath("//*[@id='mainBesidaHolder']/div[1]/div[1]/div/div[1]/div/div[2]/div[2]"));
            wait.until(ExpectedConditions.elementToBeClickable(archivedChats)).click();
        }
        @Step ("Check if archived chats list is empty")
        public boolean archivedChatListIsDisplayed() {
            chatEmptyMessage = driver.findElement(By.xpath("//div[@class='besida-notice__imageHolder--eGa7Z']"));
           return chatEmptyMessage.isDisplayed();
        }

    }








