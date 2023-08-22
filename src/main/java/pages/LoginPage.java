package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ReadProperties;

import java.time.Duration;

import static service.IConstantsUtils.FIFTY_TIMEOUT;


public class LoginPage {

    private final WebDriver driver;

    private final By emailField = new By.ByXPath("//*[@id=\"email\"]");

    private final By passwordField = new By.ByXPath("//*[@id=\"password\"]");

    private final By loginButton = new By.ByXPath("//*[@id=\"__next\"]/div/main/div/div/form/div/div[2]/button[1]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);

    }


    public LoginPage enterValidCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FIFTY_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));

        driver.findElement(emailField).sendKeys(ReadProperties.readProperties("fitnessPal_mail"));
        driver.findElement(passwordField).sendKeys(ReadProperties.readProperties("fitnessPal_password"));
        return new LoginPage(driver);
    }


}
