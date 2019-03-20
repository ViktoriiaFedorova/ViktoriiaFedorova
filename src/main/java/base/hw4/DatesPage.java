package base.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DatesPage {

    @FindBy(css = "[class^='uui-slider blue']")
    public static SelenideElement slider;

    @FindBy(css = "[class^='ui-slider-handle']")
    public static ElementsCollection sliderHandles;

    public void setSliderHandlesToItsExtremes(){

//        $("#similarityv").shouldHave(text(“0.8”));
//        executeJavaScript(“document.getElementById(‘Similarity’).style.display = ‘inline’;”);
//        $("#Similarity").val(“0.7”);

        sliderHandles.get(0).shouldHave(Condition.text());
        sliderHandles.get(1).setValue("100");
    }
}
