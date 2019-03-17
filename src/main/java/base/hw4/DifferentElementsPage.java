package base.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.DifferentElementsTexts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;

public class DifferentElementsPage {

    @FindBy(css = "[class='label-checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "[class='label-radio']")
    private ElementsCollection radios;

    @FindBy(css = "select[class='uui-form-element']")
    private ElementsCollection dropdown;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "[name='log-sidebar'] div>ul>li")
    private ElementsCollection log;

    public void checkDifferentElementsTitle(DifferentElementsTexts differentElementsTitle){
        Assert.assertEquals(title().toUpperCase(), differentElementsTitle.getText());
    }

    //is it needed to check elements' texts here?
    public void checkElements(){
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        dropdown.shouldHaveSize(1);
        buttons.shouldHaveSize(2);
    }

    public void checkRightSection(){
        rightSection.isDisplayed();
    }

    public void checkLeftSection(){
        leftSection.isDisplayed();
    }

    public void selectCheckboxByName(String checkboxName){
        SelenideElement checkbox = checkboxes.find(Condition.text(checkboxName)).find("input");
        checkbox.click();
        checkbox.shouldBe(Condition.selected);
    }

    //TODO param
    public void checkLog(String logRow){
        log.get(0).shouldHave(Condition.text(logRow));
    }

    public void selectRadio(){
        radios.get(4).click();
    }

    //TODO param
    public void checkLogForRadios(){
        $$(By.cssSelector("[name='log-sidebar'] div>ul>li")).shouldHaveSize(1);
    }

    public void selectDropdownOption(){
        dropdown.get(4).click();
    }

    //TODO param
    public void checkLogForDropdown(){
        $$(By.cssSelector("[name='log-sidebar'] div>ul>li")).shouldHaveSize(1);
    }

}
