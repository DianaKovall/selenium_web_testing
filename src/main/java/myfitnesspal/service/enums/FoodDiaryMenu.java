package myfitnesspal.service.enums;

import myfitnesspal.pages.menus.mainMenu.foodDiaryMenu.*;

public enum FoodDiaryMenu {

    FOOD_DIARY("Food", FoodDiaryPage.class),
    DATABASE("Database", DatabasePage.class),
    MY_FOODS("My Foods", MyFoodsPage.class),
    MY_MEALS("My Meals", MyMealsPage.class),
    RECIPES("Recipes", RecipesPage.class),
    SETTINGS("Settings", SettingsPage.class);

    private final String pageName;
    private final Class<?> className;

    FoodDiaryMenu(String pageName, Class<?> className) {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<?> getClassName() {
        return className;
    }


    public String getMainMenuPage() {
        return MainMenu.FOOD_DIARY.getPageName();
    }

}
