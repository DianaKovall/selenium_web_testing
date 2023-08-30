package myfitnesspal.pages.modals;

import myfitnesspal.pages.menus.mainMenu.MyAbstractPage;
import myfitnesspal.service.enums.AppGalleryMenu;
import myfitnesspal.service.enums.FoodDiaryMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import static myfitnesspal.service.utils.IConstantsUtils.TWENTY_TIMEOUTS;


public class MainMenuModal {

    private final By menuElement = new By.ByXPath("//*[@id=\"__next\"]/div/header/div[2]/div/div/div[2]/a[text()='%s']");

    private WebDriver driver;

    public MainMenuModal(WebDriver driver) {
        this.driver = driver;
    }

    public MyAbstractPage openPageFromMainMenu(Enum<?> mainMenu) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        if (mainMenu instanceof FoodDiaryMenu) {
            FoodDiaryMenu foodDiaryMenu = (FoodDiaryMenu) mainMenu;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TWENTY_TIMEOUTS));
            String dynamicXPath = String.format(
                    "//*[@id=\"__next\"]/div/header/div[2]/div/div/div[2]/a[text()='%s']",
                    foodDiaryMenu.getMainMenuPage());
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));
            element.click();

            driver.findElement(By.xpath(String.format("//*[@id=\"subNav\"]/li[3]/a[text()='%s']", foodDiaryMenu.getPageName()))).click();
            Constructor<?> constructor = foodDiaryMenu.getClassName().getConstructor(WebDriver.class);
            return (MyAbstractPage) constructor.newInstance(driver);
        }
        if (mainMenu instanceof AppGalleryMenu) {
            AppGalleryMenu appGalleryMenu = (AppGalleryMenu) mainMenu;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TWENTY_TIMEOUTS));
            String dynamicXPath = String.format("//*[@id=\"__next\"]/div/header/div[2]/div/div/div[5]/a[text()='%s']", appGalleryMenu.getMainMenuPage());
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));
            element.click();
            driver.findElement(By.xpath(String.format("//*[@id=\"subNav\"]/li[1]/a[text()='%s']", appGalleryMenu.getPageName()))).click();
            Constructor<?> constructor = appGalleryMenu.getClassName().getConstructor(WebDriver.class);
            return (MyAbstractPage) constructor.newInstance(driver);
        }
        return null;
    }


}
