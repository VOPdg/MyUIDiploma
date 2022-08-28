package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartPage {
    SelenideElement
            startOrderButton = $("#nav_text_collapse"),
            acceptAllCookieBytton = $("#cmpwelcomebtnyes");

    @Step("Open page")
    public StartPage openPage() {
        open("");
        acceptAllCookieBytton.click();
        return this;
    }

    @Step("Check Abo bestellen item")
    public void checkOrderItem() {
        startOrderButton.shouldHave(text("Abo bestellen"));
    }

    @Step("Start Order")
    public void startOrder() {
        startOrderButton.$(byText("Abo bestellen")).click();
        Selenide.sleep(5000);
    }

}
