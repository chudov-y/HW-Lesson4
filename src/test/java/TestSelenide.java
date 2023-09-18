import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenide {

    String jUnit5Class = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void findSoftAssertions(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(withText("Show")).click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").closest("h4").sibling(0).shouldHave(text(jUnit5Class));

    }

}
