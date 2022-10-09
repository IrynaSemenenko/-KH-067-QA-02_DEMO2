import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SellerContactFragment extends BasePage{
    WebElement titleContact;
    public SellerContactFragment(WebDriver driver) {
        super(driver);
    }
    public String getTitleContact(){
        titleContact = driver.findElement(By.xpath("//span[@class = '_3Trjq od97W vj3pM aXB7S F7Tdh']"));
        return titleContact.getText();
    }
}
