import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Lesson5_1 {

    @Test
    void Lesson5_1_Test() {
        System.setProperty("selenide.timeout", "5000");
        open("https://github.com/");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprises")).click();
        $(".enterprise-hero").shouldHave(text("The AI-powered developer platform"));

    }
}
