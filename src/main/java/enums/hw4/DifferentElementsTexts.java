package enums.hw4;

public enum DifferentElementsTexts {

    PAGE_TITLE("Different Elements"),
    CHECKBOX_WATER("Water"),
    CHECKBOX_EARTH("Earth"),
    CHECKBOX_WIND("Wind"),
    CHECKBOX_FIRE("Fire");

    private String text;

    DifferentElementsTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text.toUpperCase();
    }
}
