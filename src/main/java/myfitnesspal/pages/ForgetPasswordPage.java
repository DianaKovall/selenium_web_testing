package myfitnesspal.pages;

import myfitnesspal.service.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static myfitnesspal.service.utils.IConstantsUtils.*;


public class ForgetPasswordPage {

    private final WebDriver driver;


    private final By emailField = new By.ById("outlined-required");

    private final By submitButton = new By.ByXPath("//*[@id=\"__next\"]/div/div/main/div/form/div/button");

    private final By receivedPasswordMessage = new By.ByXPath("//*[@id=\"__next\"]/div/div/main/div/h1");


    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    public ForgetPasswordPage submitEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FORTY_TIMEOUTS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outlined-required")));
        driver.findElement(emailField).sendKeys(ReadProperties.readProperties("fitnessPal_mail"));
        driver.findElement(submitButton).click();
        return new ForgetPasswordPage(driver);
    }

    public boolean isConfirmMessageDisplayed()
    {
        return driver.findElement(receivedPasswordMessage).getText().equals(PASSWORD_CONFIRM);
    }


}
