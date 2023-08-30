package myfitnesspal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

public class JenkinsTests {
    private WebDriver driver;
    @Test
    public void testEasy() {

        driver.get("https://testautomationu.applitools.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        AssertJUnit.assertEquals("Test Automation University | Applitools", title);
    }

    @Test
    public void testTwo() {

        driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();

        String title1 = driver.getTitle();
        AssertJUnit.assertEquals("Google", title1);
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
