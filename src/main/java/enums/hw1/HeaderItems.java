package enums.hw1;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum HeaderItems {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    private String itemText;

    HeaderItems(String itemText) {
        this.itemText = itemText;
    }

    //✅ TODO: use toString
    @Override
    public String toString() {
        return itemText;
    }

}
