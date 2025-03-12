import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {
    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void checkTitleTest() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\ndeveloper platform"));
    }
}
