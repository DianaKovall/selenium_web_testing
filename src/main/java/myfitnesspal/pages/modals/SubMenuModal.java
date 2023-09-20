package myfitnesspal.pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SubMenuModal {

    private final By menuElement = new By.ByXPath("//*[@id=\"subNav\"]/li[3]/a[text()='%s']");

    private final WebDriver driver;

    public SubMenuModal(WebDriver driver) {
        this.driver = driver;
    }

}
