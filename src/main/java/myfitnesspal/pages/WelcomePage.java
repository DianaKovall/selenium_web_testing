package myfitnesspal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage{

    private final By loginButton = new By.ByXPath("//*[@id=\"__next\"]/div/header/div/div/a/span");
    private final WebDriver driver;

    public WelcomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public LoginPage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }


}
