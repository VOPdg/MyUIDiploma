import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;


@Tag("ABO")
public class OrderStepsTest extends TestBase {
    @Test
    void checkAbilityToMakeOrder() {
        step("Open page", () -> {
            open("");
            $("#cmpwelcomebtnyes").click();
        });
        step("Check Abo bestellen item", () -> {
            $("#nav_text_collapse").shouldHave(text("Abo bestellen"));
        });
    }

    @Test
    void opportunityToGoToOrderPage() {
        step("Open page", () -> {
            open("");
            $("#cmpwelcomebtnyes").click();
            $("#nav_text_collapse").$(byText("Abo bestellen")).click();
            sleep(5000);
        });
        step("Checking necessary order page", () -> {
            $(".wrapper").shouldHave(text("BVG-Abo online bestellen"));
        });
    }

    @Test
    void checkAvailableZone() {
        step("Open page", () -> {
            open("");
            $("#cmpwelcomebtnyes").click();
        });
        step("Choose the ticket", () -> {
            $("#nav_text_collapse").$(byText("Abo bestellen")).click();
            sleep(5000);
            $$(".card").findBy(text("VBB-Umweltkarte")).$("button").click();
        });
        step("Check necessary Zone Berlin ABC", () -> {
            $(".button-list-block").$(byText("Berlin ABC")).click();
             Assertions.assertEquals("Berlin ABC", $(".sub-row-item").$("input").getValue());
        });

    }
    @Test
    void checkTheZipCity(){
        step("Open page", () -> {
            open("");
            $("#cmpwelcomebtnyes").click();
        });
        step("Choose the ticket", () -> {
            $("#nav_text_collapse").$(byText("Abo bestellen")).click();
            sleep(5000);
            $$(".card").findBy(text("VBB-Umweltkarte")).$("button").click();
        });
        step("Select price options", () -> {
            $(".button-list-block").$(byText("Berlin ABC")).click();
            $(".price-next-step").$("button").click();
        });
        step("Fill Personal data", () -> {
            SelenideElement title = $$(".row").findBy(text("Anrede"));
            /*$("#vs6__combobox").*/
            title.$("[role=combobox]").$("[placeholder='Bitte wählen']").sendKeys("");
            title.$("[role=listbox]").$(byText("Herr")).click();
            $("[name=firstName]").setValue("Andy");
            $("[name=lastName]").setValue("Rgjf");
            $("[name=birthday]").setValue("01.02.2000");

            SelenideElement zipCity = $$(".row").findBy(text("PLZ"));
            zipCity.$("[role=combobox]").$("[placeholder='PLZ auswählen / Ort auswählen']").setValue("30159");
            zipCity.$("[role=listbox]").shouldHave(text("30159 Hannover"));
        });
    }

    @Test
    void makeOrderTest() throws InterruptedException {
        step("Open page", () -> {
            open("");
            $("#cmpwelcomebtnyes").click();
        });
        step("Choose the ticket", () -> {
            $("#nav_text_collapse").$(byText("Abo bestellen")).click();
            sleep(5000);
            $$(".card").findBy(text("VBB-Umweltkarte")).$("button").click();
        });
        step("Select price options", () -> {
            $(".button-list-block").$(byText("Berlin ABC")).click();
            $(".price-next-step").$("button").click();
        });
        step("Fill Personal data", () -> {
            SelenideElement title = $$(".row").findBy(text("Anrede"));
            /*$("#vs6__combobox").*/
            title.$("[role=combobox]").$("[placeholder='Bitte wählen']").sendKeys("");
            title.$("[role=listbox]").$(byText("Herr")).click();
            $("[name=firstName]").setValue("Andy");
            $("[name=lastName]").setValue("Rgjf");
            $("[name=birthday]").setValue("01.02.2000");

            SelenideElement zipCity = $$(".row").findBy(text("PLZ"));
            zipCity.$("[role=combobox]").$("[placeholder='PLZ auswählen / Ort auswählen']").setValue("30159");
            zipCity.$("[role=listbox]").$(byText("30159 Hannover")).click();


            SelenideElement street = $$(".row").findBy(text("Straße"));
            street.$("[role=combobox]").$("[placeholder='Straße auswählen']").setValue("he");
            street.$("[role=listbox]").$(byText("Hedwigstr.")).click();

            $("[name=streetNumber]").setValue("4");

            SelenideElement confirm = $$(".form-block").findBy(text("Rechtliches")).scrollTo();
            confirm.$(".checkbox-component").click();

            $("#nextStep").click();
        });

        step("Fill Bank data", () -> {
            $("[name=iban]").setValue("DE46500105175963927676");
            $(".row-check").$(".checkbox-component").click();
            $("#nextStep").click();
            $("#kc-page-title").shouldHave(text("Anmelden"));
        });
    }
}


