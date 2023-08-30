package myfitnesspal.pages.menus.mainMenu.foodDiaryMenu;

import myfitnesspal.pages.menus.mainMenu.MyAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.page.Page;

import java.util.List;

public class MyFoodsPage extends MyAbstractPage {

    private final WebDriver webDriver;

    private By searchField = By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/form/div/input");

    private By searchingResult = By.xpath("//*[@id=\"__next\"]/div/div/main/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/span");


    public MyFoodsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public MyFoodsPage searchForFood(String foodName) {
        webDriver.findElement(searchField).sendKeys(foodName + "" + Keys.ENTER);
        return new MyFoodsPage(webDriver);
    }


    public boolean isSearchedResultsAsExpected(String foodName) {
        List<WebElement> resultList = webDriver.findElements(searchingResult);

        return resultList.stream()
                .map(WebElement::getText)
                .allMatch(actualText -> actualText.equals(foodName));
    }

}
