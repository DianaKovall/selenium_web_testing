package myfitnesspal.pages.menus.mainMenu.foodDiaryMenu;

import myfitnesspal.pages.menus.mainMenu.MyAbstractPage;
import org.openqa.selenium.WebDriver;

public class FoodDiaryPage extends MyAbstractPage {

    private final WebDriver webDriver;

    public FoodDiaryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
