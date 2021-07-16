package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FindSoftAssertions {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenidePagesFindSoftAssertions() {
        open("https://github.com/selenide/selenide");
        $("[data-content=Wiki]").click();
        $("#wiki-pages-filter").setValue("SoftAssertion");
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
