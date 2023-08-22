package service;

import java.util.ResourceBundle;


public class ReadProperties {


    public static String readProperties(String value) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("_testdata");
        return resourceBundle.getString(value);
    }


}
