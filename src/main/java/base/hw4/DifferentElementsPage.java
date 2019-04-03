package base.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.DifferentElementsTexts;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

    @Step("Displayed page title should be <{differentElementsTitle.text}>")
    public void checkDifferentElementsTitle(DifferentElementsTexts differentElementsTitle) {
        assertThat(title().toUpperCase(), is(differentElementsTitle.getText().toUpperCase()));
    }

    //is it needed to check elements' texts here?
    @Step("There are the following elements on Different Elements page: 4 checkboxes, 4 radios, 1 dropdown, 2 buttons")
    public void checkElements() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        dropdown.shouldBe(Condition.exist);
        buttons.shouldHaveSize(2);
    }

    @Step("There is right section on Different Elements page")
    public void checkRightSection() {
        rightSection.isDisplayed();
    }

    @Step("There is left section on Different Elements page")
    public void checkLeftSection() {
        leftSection.isDisplayed();
    }

    @Step("Click the following elements: <{elementsNames}>")
    public void selectElementByName(ElementsCollection elements, DifferentElementsTexts... elementsNames) {
        for (DifferentElementsTexts checkboxName : elementsNames) {
            SelenideElement inputAttribute = elements.find(text(checkboxName.getText())).find("input");
            inputAttribute.click();
        }
    }

    @Step("There is a record in log for <{elementName}> = <{elementState}>")
    public void checkLog(ElementsCollection elements, DifferentElementsTexts elementName, Boolean elementState) {
        SelenideElement inputAttribute = elements.find(text(elementName.getText())).find("input");
        if (elementState)
            inputAttribute.shouldHave(Condition.checked);
        else
            inputAttribute.shouldNotHave(Condition.checked);

        for (SelenideElement aLog : log) {
            if (aLog.getText().contains(elementName.getText().toUpperCase())) {
                aLog.shouldHave(text(elementState.toString()));
            }
        }
    }

    @Step("There is a record in log for <{elementName}> = <{elementState}>")
    public void checkLogForDropdown(SelenideElement element, DifferentElementsTexts elementName, Boolean elementState) {
        if (elementState)
            element.getSelectedOption().shouldHave(text(elementName.getText()));
        else
            element.getSelectedOption().shouldHave(text(elementName.getText()));

        for (SelenideElement aLog : log) {
            if (aLog.getText().contains(elementName.getText().toUpperCase())) {
                aLog.shouldHave(text(elementState.toString()));
            }
        }
    }

}
