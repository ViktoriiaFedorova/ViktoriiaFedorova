package hw4;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class TestForServicePage {

    @Test
    public void testForServicePage(){

        $("[id='user-icon']").click();

    }

}
