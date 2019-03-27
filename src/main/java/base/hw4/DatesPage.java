package base.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DatesPage {

    @FindBy(css = "[class^='uui-slider']")
    private SelenideElement slider;

    @FindBy(css = "a.ui-slider-handle:nth-child(1)")
    public static SelenideElement leftSliderHandle;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    public static SelenideElement rightSliderHandle;

    @FindBy(css = "[class='panel-body-list logs'] li")
    public static ElementsCollection log;

    public void setSliderHandleToPosition(SelenideElement sliderHandle, int position) {

        int offset = slider.getSize().width * (position - Integer.valueOf(sliderHandle.lastChild().getText())) / 100 - 1;
        Selenide.actions().clickAndHold(sliderHandle).moveByOffset(offset, 0).release().build().perform();
    }

    public void checkLogForSliderHandlePosition(SelenideElement sliderHandle, int position) {

        String nameForLog = "";
        if (sliderHandle == leftSliderHandle)
            nameForLog = "From";
        else if (sliderHandle == rightSliderHandle)
            nameForLog = "To";

        for (SelenideElement logRecord : log) {
            if (logRecord.getText().contains(nameForLog)) {
                logRecord.shouldHave(text(Integer.valueOf(position).toString()));
                break;
            }
        }
    }
}
