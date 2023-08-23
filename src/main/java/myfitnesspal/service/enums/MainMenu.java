package myfitnesspal.service.enums;

import myfitnesspal.pages.menus.mainMenu.*;
import myfitnesspal.pages.menus.mainMenu.foodDiaryMenu.FoodDiaryPage;

public enum MainMenu {

    MY_HOME("My Home", MyHomePage.class),
    FOOD_DIARY("Food", FoodDiaryPage.class),
    EXERCISE("Exercise", ExercisePage.class),
    REPORTS("Reports", ReportsPage.class),
    APPS("Apps", AppsPage.class),
    COMMUNITY("Community", CommunityPage.class),
    BLOG("Blog", BlogPage.class),
    PREMIUM("Premium", PremiumPage.class);


    private final String pageName;
    private final Class<?> className;

    MainMenu(String pageName, Class<?> className) {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<?> getClassName() {
        return className;
    }
}
