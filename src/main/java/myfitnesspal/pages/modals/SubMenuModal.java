package myfitnesspal.pages.modals;

import myfitnesspal.service.enums.FoodDiaryMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v109.page.Page;


import java.lang.reflect.Constructor;

public class SubMenuModal {

    private final By menuElement = new By.ByXPath("//*[@id=\"subNav\"]/li[3]/a[text()='%s']");

    private final WebDriver driver;

    public SubMenuModal(WebDriver driver) {
        this.driver = driver;
    }


    public Page openPageFromSubMenu(FoodDiaryMenu foodDiaryMenu) {
        driver.findElement(By.xpath(String.format("//*[@id=\"subNav\"]/li[3]/a[text()='%s']", foodDiaryMenu.getPageName()))).click();
        return instantiatePage(foodDiaryMenu.getClassName());
    }

    public Page instantiatePage(Class<?> pageClass) {
        try {
            Constructor<?> constructor = pageClass.getConstructor(WebDriver.class);
            return (Page) constructor.newInstance(driver);
        } catch (Exception e) {
            return null;
        }
    }



}
