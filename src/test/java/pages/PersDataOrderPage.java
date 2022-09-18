package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersDataOrderPage {
    ElementsCollection rows = $$(".row");
    SelenideElement titleDropdown = rows.findBy(text("Anrede")),
            zipCityDropdown = rows.findBy(text("PLZ")),
            firstNameInput = $("[name=firstName]"),
            lastNameInput = $("[name=lastName]"),
            birthdayInput = $("[name=birthday]"),
            streetDropdown = rows.findBy(text("Straße")),
            streetNumberInput = $("[name=streetNumber]"),
            confirmCheckbox = $$(".form-block").findBy(text("Rechtliches")),
            nextStepButton = $("#nextStep");

    @Step("Set title: {value}")
    public void setTitle(String value) {
        titleDropdown.$("[role=combobox]").$("[placeholder='Bitte wählen']").sendKeys("");
        titleDropdown.$("[role=listbox]").$(byText(value)).click();
    }

    @Step("Set name: {firstName} {lastName}")
    public void setName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
    }

    @Step("Set birth: {value}")
    public void setBirthday(String value) {
        birthdayInput.setValue(value);
    }

    @Step("Check zip and city: {value}")
    public void checkZip(String value) {
        zipCityDropdown.$("[role=combobox]").$("[placeholder='PLZ auswählen / Ort auswählen']").setValue(value);
        zipCityDropdown.$("[role=listbox]").shouldHave(text(value));
    }

    @Step("Set zip and city: {value}")
    public void setZip(String value) {
        zipCityDropdown.$("[role=combobox]").$("[placeholder='PLZ auswählen / Ort auswählen']").setValue(value);
        zipCityDropdown.$("[role=listbox]").$$("li").first().click();
    }

    @Step("Set street: {value}")
    public void setStreet(String value) {
        streetDropdown.$("[placeholder='Straße auswählen']").setValue(value);
        streetDropdown.$("[role=listbox]").$$("li").first().click();
    }

    @Step("Set number house: {value}")
    public void setHouse(String value) {
        streetNumberInput.setValue(value);
    }

    @Step("Go to next step")
    public void clickNextButton() {
        confirmCheckbox.scrollTo();
        confirmCheckbox.$(".checkbox-component").click();
        nextStepButton.click();
    }
}
