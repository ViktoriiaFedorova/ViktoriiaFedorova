package base.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class DatesPage {

    @FindBy(css = "[class^='uui-slider blue']")
    public static SelenideElement sliderLine;

    @FindBy(css = "[class^='ui-slider-handle']:first-child")
    public static SelenideElement slider;

    public void setSliderHandlesToItsExtremes() {

//        $("#similarityv").shouldHave(text(“0.8”));
//        executeJavaScript(“document.getElementById(‘Similarity’).style.display = ‘inline’;”);
//        $("#Similarity").val(“0.7”);

        //slider.get(0).shouldHave(Condition.text("0"));
        //slider.get(1).setValue("100");

        //632(570) and 880 248
//        int i = (int) (2 * 3.1);
//        int delta = i - i/30;
//        Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(delta,0).release().build().perform();
//        System.out.println();

        int sliderLength = sliderLine.getSize().width;
        int sliderStart = sliderLine.getLocation().x;

        int sliderStep = sliderLength / 100;

        int handleSize = slider.getSize().width;
        int handleLocation = slider.getLocation().x + handleSize / 2;
//        Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(- (handleLocation - sliderStart), 0).release().build().perform();
//
//        int newHandleLocation = slider.get(0).getLocation().x;
//        if (newHandleLocation != (sliderStart - 10) && !slider.get(0).getAttribute("style").contains(" 0%")){
//            Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(- handleSize/2, 0).release().build().perform();
//        }
//
//        int targetPosition = 56;
//        Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(sliderStep * targetPosition, 0).release().build().perform();
//
//        int nextHandleLocation = slider.get(0).getLocation().x;
//        if (nextHandleLocation != (sliderStart - 10 + sliderStep * targetPosition) && !slider.get(0).getAttribute("style").contains(" 56%")){
//            Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(- (nextHandleLocation - sliderStart - 10 + sliderStep * targetPosition), 0).release().build().perform();
//        }
//        int lastHandleLocation = slider.get(0).getLocation().x;
//
//        System.out.println("end1");

//        int location1 = slider.get(0).getLocation().x;
//        Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(50, 0).release().build().perform();
//        int location2 = slider.get(0).getLocation().x;
//        if (location2 != location1 + 50)
//            Selenide.actions().clickAndHold(slider.get(0)).moveByOffset(location1 + 50 - location2, 0).release().build().perform();
//        int location3 = slider.get(0).getLocation().x;

        Actions actions = Selenide.actions();
        Action action = null;
        while (true) {
            System.out.println(slider.getLocation());
            System.out.println(slider.getText());

            Actions actions1 = Selenide.actions().moveToElement(slider);
            int x = 17;
            if (!slider.getText().equals(String.valueOf(x))) {
//                int y = -1;
                System.out.println(MouseInfo.getPointerInfo().getLocation());

                actions1.clickAndHold().moveByOffset(-1,0).build().perform();

                System.out.println(MouseInfo.getPointerInfo().getLocation());
                System.out.println(slider.getLocation());
            } else {
                actions1.release(slider).build().perform();
                System.out.println(slider.getLocation());
                System.out.println("Конченный getLocation:" + slider);
                break;
            }
        }
        System.out.println("dsdfsdf");


//        System.out.println("end2");
    }
}
