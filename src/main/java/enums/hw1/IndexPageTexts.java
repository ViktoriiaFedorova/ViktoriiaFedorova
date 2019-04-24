package enums.hw1;

public enum IndexPageTexts {
    PAGE_TITLE("Home Page"),
    MAIN_TITLE("EPAM framework Wishes…"),
    JDI_TEXT("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
    SUB_HEADER("JDI Github", "https://github.com/epam/JDI");

    private String text;
    private String linkURL;

    IndexPageTexts(String text) {
        this.text = text;
    }

    IndexPageTexts(String text, String linkURL) {
        this.text = text;
        this.linkURL = linkURL;
    }

    public String getText() {
        return text.toLowerCase();
    }

    public String getLinkURL() {
        return linkURL;
    }
}
