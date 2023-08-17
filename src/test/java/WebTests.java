import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class WebTests {

    Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        LOGGER.info(String.format("title %s", driver.getTitle()));
        driver.quit();
    }


    @Test()
    public void loginTest() {
        setUp();
    }


}
