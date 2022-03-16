package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            resultsTable = $(".table-responsive"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            subjectInput = $("#subjectsInput"),
            emailInput = $("#userEmail"),
            adressInput = $("#currentAddress"),
            phoneNumberInput = $("#userNumber"),
            genderInput = $(byText("Other")),
            hobbyInput = $(byText("Sports")),
            pictureUpload = $("#uploadPicture"),
            selectStateInput = $("#state"),
            stateInput = $(byText("NCR")),
            selectCityInput = $("#city"),
            cityInput = $(byText("Delhi")),
            submitInput = $("#submit");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public void setLastName (String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setGenderInput() { genderInput.click();

    }

    public void setEmail(String email) { emailInput.setValue(email);}

    public void setAdress(String adress) { adressInput.setValue(adress);}

    public RegistrationPage setHobby() {

        hobbyInput.click();

        return this;
    }

    public void setPicture() { pictureUpload.uploadFile(new File("src/test/resources/img/1.png"));}


    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }
    public RegistrationPage setState() {
        selectStateInput.click();
        stateInput.click();
        return this;
    }

    public RegistrationPage setCity() {
        selectCityInput.click();
        cityInput.click();
        return this;
    }

    public void setPhoneNumber(String phoneNumber) { phoneNumberInput.setValue(phoneNumber);}

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }
    public RegistrationPage clickOnSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}
