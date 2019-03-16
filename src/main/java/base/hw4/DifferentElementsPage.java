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
        $$(By.cssSelector("[class='label-checkbox']")).shouldHaveSize(4);
        $$(By.cssSelector("[class='label-radio']")).shouldHaveSize(4);
        $$(By.cssSelector("select[class='uui-form-element']")).shouldHaveSize(1);
        $$(By.cssSelector("[class='uui-button']")).shouldHaveSize(2);
    }

    public void checkRightSection(){
        rightSection.isDisplayed();
    }

    public void checkLeftSection(){
        leftSection.isDisplayed();
    }

    public void selectCheckboxes(){
        checkboxes.get(1).click();
        checkboxes.get(3).click();
    }

    public void checkLog(){
        $$(By.cssSelector("[name='log-sidebar'] div>ul>li")).shouldHaveSize(2);
    }

}
