import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest implements ITestListener {
    WebDriver driver;
    public static final String MAIN_PAGE_URL = "https://prom.ua/";
    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE_URL);
//        driver.manage().deleteAllCookies();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            TakesScreenshot scr = ((TakesScreenshot) driver);
            byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("[dd_MM_yyyy__HH_mm_ss]"));
            String fileName = "failed_" + now + ".png";
            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                fileOutputStream.write(screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
