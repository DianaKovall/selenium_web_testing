package myfitnesspal;

import myfitnesspal.pages.ForgetPasswordPage;
import myfitnesspal.pages.menus.mainMenu.MyAbstractPage;
import myfitnesspal.pages.menus.mainMenu.appGalleryMenu.AppGalleryPage;
import myfitnesspal.pages.menus.mainMenu.foodDiaryMenu.MyFoodsPage;
import myfitnesspal.pages.modals.MainMenuModal;
import myfitnesspal.service.enums.AppGalleryMenu;
import myfitnesspal.service.enums.AppsCategories;
import myfitnesspal.service.enums.FoodDiaryMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

import myfitnesspal.base.BaseTests;
import myfitnesspal.pages.menus.mainMenu.MyHomePage;
import myfitnesspal.pages.LoginPage;

import java.lang.reflect.InvocationTargetException;

public class MyFitnessPalTests extends BaseTests {


    public final String FOOD_FOR_SEARCH = "Bread";
    public final AppsCategories CATEGORY = AppsCategories.FERTILITY;

    @Test
    public void loginTest() {
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        loginPage.enterValidCredentials();
        MyHomePage myHomePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(myHomePage.isHomePageOpened(), "[ HOME PAGE ] Home page is not opened!");
    }

    @Test
    public void searchTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        loginPage.enterValidCredentials();
        MyHomePage myHomePage = loginPage.clickOnLoginButton();
        if (myHomePage.isHomePageOpened()) {
            MainMenuModal mainMenuModal = new MainMenuModal(driver);
            MyFoodsPage myFoodsPage = (MyFoodsPage) mainMenuModal.openPageFromMainMenu(FoodDiaryMenu.MY_FOODS);
            myFoodsPage.searchForFood(FOOD_FOR_SEARCH);
            Assert.assertTrue(myFoodsPage.isSearchedResultsAsExpected(FOOD_FOR_SEARCH),
                    "[ MY FOODS PAGE] Searched results are not as expected!");
        }

    }


    @Test
    public void forgetPasswordTest() {
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        ForgetPasswordPage forgetPasswordPage = loginPage.clickOnForgetPasswordButton();
        forgetPasswordPage.submitEmail();
        Assert.assertTrue(forgetPasswordPage.isConfirmMessageDisplayed(),
                "[ FORGET PASSWORD PAGE ] Password confirm message was not displayed!");

    }


    @Test
    public void sortProductTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        loginPage.enterValidCredentials();
        MyHomePage myHomePage = loginPage.clickOnLoginButton();
        if (myHomePage.isHomePageOpened()) {
            MainMenuModal mainMenuModal = new MainMenuModal(driver);
            AppGalleryPage appGalleryPage = (AppGalleryPage) mainMenuModal.openPageFromMainMenu(AppGalleryMenu.APP_GALLERY_MENU_MENU);
            appGalleryPage.chooseCategory(CATEGORY);
            Assert.assertTrue(appGalleryPage.areItemsSortedByCategory(CATEGORY),
                    String.format("[ APP GALLERY ] Items are not sorted as expected! Category:'%s'", CATEGORY.getCategoryName()));
        }
    }
}
