package enums.hw4;

public enum DifferentElementsTexts {

    PAGE_TITLE("Different Elements"),
    CHECKBOX_WATER("Water"),
    CHECKBOX_EARTH("Earth"),
    CHECKBOX_WIND("Wind"),
    CHECKBOX_FIRE("Fire"),
    RADIO_Gold("Gold"),
    RADIO_Silver("Silver"),
    RADIO_Bronse("Bronse"),
    RADIO_Selen("Selen"),
    COLOR_Red("Red"),
    COLOR_Green("Green"),
    COLOR_Blue("Blue"),
    COLOR_Yellow("Yellow");

    private String text;

    DifferentElementsTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text.toUpperCase();
    }
}
