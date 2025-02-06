package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = " https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("mp@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9550012345");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1985");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("31")).click();
        $("#subjectsInput").setValue("Literature").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("maria.png");
        $("#currentAddress").setValue("Russia");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Maria Petrova"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("mp@gmail.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("9550012345"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("31 December,1985"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Literature"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("maria.png"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Russia"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Haryana Karnal"));
    }
}
