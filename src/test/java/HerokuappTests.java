import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HerokuappTests {
    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1920 x 1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void checkDragAndDropTest() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void checkDragAndDropActionTest() {
        String a = "#column-a";
        String b = "#column-b";
        open("/drag_and_drop");
        $(a).shouldHave(text("A"));
        $(b).shouldHave(text("B"));
        actions().moveToElement($(a)).clickAndHold().moveToElement($(b)).release().perform();
        $(a).shouldHave(text("B"));
        $(b).shouldHave(text("A"));
    }
}
