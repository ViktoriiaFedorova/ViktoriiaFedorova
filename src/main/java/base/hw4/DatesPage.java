package base.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DatesPage {

    @FindBy(css = "[class^='uui-slider blue']")
    public static SelenideElement slider;

    @FindBy(css = "[class^='ui-slider-handle']")
    public static ElementsCollection sliderHandles;

    public void setSliderHandlesToItsExtremes(){
        sliderHandles.get(0).setValue("0");
        sliderHandles.get(1).setValue("100");
    }
}
