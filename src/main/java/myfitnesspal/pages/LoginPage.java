package myfitnesspal.pages;

import myfitnesspal.pages.menus.mainMenu.MyHomePage;
import myfitnesspal.service.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static myfitnesspal.service.utils.IConstantsUtils.*;

public class LoginPage {

    private final WebDriver driver;


    private final By emailField = new By.ByXPath("//*[@id=\"email\"]");

    private final By passwordField = new By.ByXPath("//*[@id=\"password\"]");

    private final By loginButton = new By.ByXPath("//*[@id=\"__next\"]/div/main/div/div/form/div/div[2]/button[1]");

    private final By forgetPasswordLink = new By.ByXPath("//*[@id=\"__next\"]/div/main/div/div/form/div/div[1]/p/a");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isLoginPageOpen() {
        return driver.findElement(emailField).isDisplayed() && driver.findElement(passwordField).isDisplayed();

    }

    public ForgetPasswordPage clickOnForgetPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FIFTY_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgetPasswordLink));
        driver.findElement(forgetPasswordLink).click();
        return new ForgetPasswordPage(driver);

    }

    private final By captchaMessage = new By.ByXPath("//*[@id=\"__next\"]/div/main/div/div/form/div/div[1]/div[text()=\"Unable to sign in. Recaptcha verification failed. Please try again.\"]");

    private final By loginButtonCaptcha = new By.ByXPath("//*[@id=\"__next\"]/div/main/div/div/form/div/div[3]/button[1]");

    public void reCaptchaIfPresent() {
        if(isLoginPageOpen()) {
            int attemp = 3;
            while (driver.findElement(loginButtonCaptcha).isEnabled() &&
                    driver.findElement(captchaMessage).isDisplayed() &&
                    attemp > 0) {
                attemp--;
                driver.findElement(loginButtonCaptcha).click();
                driver.manage().timeouts().implicitlyWait(TEN_TIMEOUT, TimeUnit.SECONDS);
            }
        }
    }

    public MyHomePage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(FIFTEEN_TIMEOUT, TimeUnit.SECONDS);
        reCaptchaIfPresent();
        return new MyHomePage(driver);
    }


    public LoginPage enterValidCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FIFTY_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));

        driver.findElement(emailField).sendKeys(ReadProperties.readProperties("fitnessPal_mail"));
        driver.findElement(passwordField).sendKeys(ReadProperties.readProperties("fitnessPal_password"));
        return new LoginPage(driver);
    }


}
