package enums;

public enum HeaderItems {

    HOME("HOME"),
    CONTACTFORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALSCOLORS("METALS & COLORS");

    private String itemText;

    HeaderItems(String itemText) {
        this.itemText = itemText;
    }
    //TODO: use toString
    public String getItemText() {
        return itemText;
    }
}
