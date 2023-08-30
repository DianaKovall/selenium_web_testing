package myfitnesspal.pages.menus.mainMenu.appGalleryMenu;

import myfitnesspal.pages.menus.mainMenu.MyAbstractPage;
import myfitnesspal.service.enums.AppsCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static myfitnesspal.service.utils.IConstantsUtils.TWENTY_TIMEOUTS;

public class AppGalleryPage extends MyAbstractPage {

    private final WebDriver webDriver;

    public AppGalleryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    private final By categoriesList = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div[2]");


    public AppGalleryPage chooseCategory(AppsCategories appsCategories) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(TWENTY_TIMEOUTS));
        String dynamicXPath = String.format(
                "//*[@id='content']/div/div[2]/div[2]/ul/li/a[text()='%s']",
                appsCategories.getCategoryName());
        WebElement categoryTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));
        categoryTab.click();
        return new AppGalleryPage(webDriver);

    }


    public boolean areItemsSortedByCategory(AppsCategories appsCategories) {

        return webDriver.findElements(categoriesList).stream()
                .map(WebElement::getText)
                .allMatch(actualText -> actualText.equals(appsCategories.getCategoryName()));

    }

}
