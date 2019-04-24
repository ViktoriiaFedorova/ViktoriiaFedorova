package enums.hw1;

public enum BenefitsSection {
    PRACTISE("url(\"https://epam.github.io/JDI/images/sprite.png\")",
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    CUSTOM("url(\"https://epam.github.io/JDI/images/sprite.png\")",
            "To be flexible and\n" + "customizable"),
    MULTI("url(\"https://epam.github.io/JDI/images/sprite.png\")",
            "To be multiplatform"),
    BASE("url(\"https://epam.github.io/JDI/images/sprite.png\")",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"),;

    private String benefitIcon;
    private String benefitText;

    BenefitsSection(String benefitIcon, String benefitText) {
        this.benefitIcon = benefitIcon;
        this.benefitText = benefitText;
    }

    public String getBenefitIcon() {
        return benefitIcon;
    }

    public String getBenefitText() {
        return benefitText.toLowerCase();
    }
}
