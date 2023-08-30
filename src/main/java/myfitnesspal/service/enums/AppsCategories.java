package myfitnesspal.service.enums;


public enum AppsCategories {

    All("All"),
    ACTIVITY_TRACKERS("Activity Trackers"),
    STEP_TRACKERS("Step Trackers"),
    SCALES("Scales"),
    LIFESTYLE("Lifestyle"),
    WEARABLES("Wearables"),
    FITNESS_APPS("Fitness Apps"),
    EXERCISE_APPS("Exercise Apps"),
    FERTILITY("Fertility");

    private final String categoryName;


    AppsCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
