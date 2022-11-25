package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            photoInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper").$("#state"),
            cityInput = $("#stateCity-wrapper").$("#city"),
            submitFormInput = $("#submit"),
            closeResultsFormInput = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String[] value) {
        for (String s : value) {
            subjectsInput.setValue(s).pressEnter();
        }

        return this;
    }

    public RegistrationPage setHobbies(String[] value) {
        for (String s : value) {
            hobbiesInput.$(byText(s)).click();
        }

        return this;
    }

    public RegistrationPage setPhoto(File value) {
        photoInput.uploadFile(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();


        return this;
    }

    public RegistrationPage submitForm() {
        submitFormInput.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppearance() {
        registrationResultsModal.verifyModalAppearance();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResults(key, value);

        return this;
    }

    public RegistrationPage closeResultsForm() {
        closeResultsFormInput.click();

        return this;
    }
}

