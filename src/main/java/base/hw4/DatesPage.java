package base.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DatesPage {

    @FindBy(css = "[class^='uui-slider blue']")
    public static SelenideElement slider;

    @FindBy(css = "[class^='ui-slider-handle']")
    public static ElementsCollection sliderHandles;

    public void setSliderHandlesToItsExtremes(){

//        $("#similarityv").shouldHave(text(“0.8”));
//        executeJavaScript(“document.getElementById(‘Similarity’).style.display = ‘inline’;”);
//        $("#Similarity").val(“0.7”);

        //sliderHandles.get(0).shouldHave(Condition.text("0"));
        //sliderHandles.get(1).setValue("100");

        //632(570) and 880 248
        int i = (int) (2 * 3.1);
        int delta = i - i/30;
        Selenide.actions().clickAndHold(sliderHandles.get(0)).moveByOffset(delta,0).release().build().perform();
        System.out.println();

    }
}
