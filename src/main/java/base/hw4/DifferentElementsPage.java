package base.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.DifferentElementsTexts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;

public class DifferentElementsPage {

    @FindBy(css = "[class='label-checkbox']")
    public static ElementsCollection checkboxes;

    @FindBy(css = "[class='label-radio']")
    public static ElementsCollection radios;

    @FindBy(css = "select[class='uui-form-element']")
    public SelenideElement dropdown;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "[name='log-sidebar'] div>ul[class='panel-body-list logs']>li")
    private ElementsCollection log;

    public void checkDifferentElementsTitle(DifferentElementsTexts differentElementsTitle) {
        Assert.assertEquals(title().toUpperCase(), differentElementsTitle.getText());
    }

    //is it needed to check elements' texts here?
    public void checkElements() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        dropdown.shouldBe(Condition.exist);
        buttons.shouldHaveSize(2);
    }

    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    public void checkLeftSection() {
        leftSection.isDisplayed();
    }

    public void selectElementByName(ElementsCollection elements, DifferentElementsTexts... elementsNames) {
        for (DifferentElementsTexts checkboxName : elementsNames) {
            SelenideElement inputAttribute = elements.find(text(checkboxName.getText())).find("input");
            inputAttribute.click();
        }
    }

    public void checkLog(ElementsCollection elements, DifferentElementsTexts elementName, Boolean elementState) {
        SelenideElement inputAttribute = elements.find(text(elementName.getText())).find("input");
        if (elementState)
            inputAttribute.shouldHave(Condition.checked);
        else
            inputAttribute.shouldNotHave(Condition.checked);

        for (SelenideElement aLog : log) {
            if (aLog.getText().contains(elementName.getText())) {
                aLog.shouldHave(text(elementState.toString()));
            }
        }
    }

    //TODO param
    public void checkLogForDropdown(DifferentElementsTexts elementName, Boolean elementState) {

        if (elementState)
            inputAttribute.shouldHave(Condition.checked);
        else
            inputAttribute.shouldNotHave(Condition.checked);

        for (SelenideElement aLog : log) {
            if (aLog.getText().contains(elementName.getText())) {
                aLog.shouldHave(text(elementState.toString()));
            }
        }
    }

}
