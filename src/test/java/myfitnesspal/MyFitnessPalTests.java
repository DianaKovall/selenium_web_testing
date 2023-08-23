package myfitnesspal;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.HomePage;
import pages.LoginPage;

public class MyFitnessPalTests extends BaseTests {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        loginPage.enterValidCredentials();
        HomePage homePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.isHomePageOpened(), "[ HOME PAGE ] Home page is not opened!");
    }

}
