import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {
    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkTitleTest() {
        open("https://github.com/");
        $(".HeaderMenu").$(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
//        $(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\ndeveloper platform"));
    }
}
