package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OrderPage {
    SelenideElement wrapper = $(".wrapper"),
            zone = $(".button-list-block");
    ElementsCollection cards = $$(".card");


    @Step("Checking necessary order page")
    public void checkOrderPage() {
        wrapper.shouldHave(text("BVG-Abo online bestellen"));
    }

    @Step("Choose ticket")
    public void chooseTicket(String value) {
        cards.findBy(text(value)).$("button").click();
    }

    @Step("Check necessary Zone Berlin ABC")
    public void checkZone(String value) {
        zone.$(byText(value)).click();
        $(".sub-row-item input").shouldHave(value(value));
    }

    @Step("Go to Personal data page")
    public void personalDataStep() {
        $(".price-next-step button").click();
    }
}
