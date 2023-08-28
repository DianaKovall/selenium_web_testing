package myfitnesspal.pages.modals;

import myfitnesspal.service.enums.FoodDiaryMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static myfitnesspal.service.utils.IConstantsUtils.TWENTY_TIMEOUTS;


public class MainMenuModal {

    private final By menuElement = new By.ByXPath("//*[@id=\"__next\"]/div/header/div[2]/div/div/div[2]/a[text()='%s']");

    private WebDriver driver;

    public MainMenuModal(WebDriver driver) {
        this.driver = driver;
    }


    public Page openPageFromMainMenu(FoodDiaryMenu foodDiaryMenu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TWENTY_TIMEOUTS));
        String dynamicXPath = String.format("//*[@id=\"__next\"]/div/header/div[2]/div/div/div[2]/a[text()='%s']", foodDiaryMenu.getMainMenuPage());
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));
        element.click();

        SubMenuModal subMenuModal = new SubMenuModal(driver);
       return subMenuModal.openPageFromSubMenu(foodDiaryMenu);
    }


}
