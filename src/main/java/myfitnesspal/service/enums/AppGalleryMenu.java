package myfitnesspal.service.enums;

import myfitnesspal.pages.menus.mainMenu.appGalleryMenu.AppGalleryPage;
import myfitnesspal.pages.menus.mainMenu.appGalleryMenu.BMRPage;
import myfitnesspal.pages.menus.mainMenu.appGalleryMenu.MobilePage;
import myfitnesspal.pages.menus.mainMenu.appGalleryMenu.StepsPage;

public enum AppGalleryMenu {

    APP_GALLERY_MENU_MENU("App Gallery", AppGalleryPage.class),
    MOBILE("Mobile", MobilePage.class),
    BMR("BMR", BMRPage.class),
    STEPS("Steps", StepsPage.class);

    private final String pageName;
    private final Class<?> className;

    AppGalleryMenu(String pageName, Class<?> className) {
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
        return MainMenu.APPS.getPageName();
    }

}
