package enums.hw4;

import java.util.Arrays;
import java.util.List;

public enum ServicePageOptions {

    //"Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_WITH_PAGES("Tables With Pages"),
    DIFFERENT_ELEMENTS("Different Elements");

    private String text;

    ServicePageOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text.toUpperCase();
    }

    public static List<ServicePageOptions> serviceOptionsList() {
        return Arrays.asList(ServicePageOptions.values());
    }
}
