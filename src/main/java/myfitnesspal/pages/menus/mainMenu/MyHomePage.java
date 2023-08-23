
package myfitnesspal.pages.menus.mainMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static myfitnesspal.service.utils.IConstantsUtils.FIFTY_TIMEOUT;
import static myfitnesspal.service.utils.IConstantsUtils.YOUR_DAILY_SUMMARY;


public class MyHomePage {

    private final WebDriver driver;

    private final By title = By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div/div/div[1]/div[1]/div[1]/h1");

    public MyHomePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isHomePageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FIFTY_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));

        return driver.findElement(title).getText().equals(YOUR_DAILY_SUMMARY);
    }


}
