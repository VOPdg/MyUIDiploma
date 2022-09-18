package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BankDataOrderPage {
    SelenideElement iban = $("[name=iban]"),
            nextStepButton = $("#nextStep");

    @Step("Set IBAN")
    public void setIban(String value) {
        iban.setValue(value);
    }

    @Step("Go to next step")
    public void clickNextButton() {
        $(".row-check").$(".checkbox-component").click();
        nextStepButton.click();
    }

    @Step("Check the Anmelden")
    public void checkNextStep() {
        $("#kc-page-title").shouldHave(text("Anmelden"));
    }
}
