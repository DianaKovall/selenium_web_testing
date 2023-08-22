
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static service.IConstantsUtils.FIFTY_TIMEOUT;
import static service.IConstantsUtils.YOUR_DAILY_SUMMARY;


public class HomePage {

    private final WebDriver driver;


    private final By title = By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div/div/div[1]/div[1]/div[1]/h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isHomePageOpened() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(FIFTY_TIMEOUT, TimeUnit.SECONDS);
        return driver.findElement(title).getText().equals(YOUR_DAILY_SUMMARY);
    }


}
