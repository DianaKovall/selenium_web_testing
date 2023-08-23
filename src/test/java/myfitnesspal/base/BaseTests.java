package myfitnesspal.base;

import myfitnesspal.service.utils.IConstantsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import myfitnesspal.pages.WelcomePage;
import org.testng.annotations.BeforeMethod;


import java.lang.invoke.MethodHandles;
import java.time.Duration;



public class BaseTests implements IConstantsUtils {

    Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected WebDriver driver;
    protected WelcomePage welcomePage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.myfitnesspal.com/");
        closeCookiesPopUp();

        welcomePage = new WelcomePage(driver);
    }

    public void closeCookiesPopUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FORTY_TIMEOUTS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_message_iframe_760094")));
        WebElement iframe = driver.findElement(By.id("sp_message_iframe_760094"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\"notice\"]/div[3]/button")).click();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
