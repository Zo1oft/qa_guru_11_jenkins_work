package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = "Egorov";
    String studentName = "Student Name";
    String studentNameValue = "Alex Egorov";
    String studentEmail = "Student Email";
    String gender = "Gender";
    String genderValue = "Other";
    String email = "alex1@egorov.com";
    String studentEmailValue = "alex1@egorov.com";
    String adress = "Some address 1";
    String phoneNumber = "1231231230";
    String mobile = "Mobile";
    String mobileValue = "1231231230";
    String dateOfBirth = "Date of Birth";
    String dateOfBirthValue = "30 July,2008";
    String subjects = "Maths";
    String subject = "Maths";
    String subjectsValue = "Maths";
    String hobbies = "Hobbies";
    String hobbiesValue = "Sports";
    String picture = "Picture";
    String pictureValue = "1.png";
    String stateAndCity = "State and City";
    String stateAndCityValue = "NCR Delhi";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setGenderInput();
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.setBirthDate("30", "July", "2008");
        registrationPage.setSubject(subject);
        registrationPage.setEmail(email);
        registrationPage.setAdress(adress);
        registrationPage.setHobby();
        registrationPage.setPicture();
        registrationPage.setState();
        registrationPage.setCity();
        registrationPage.clickOnSubmit();
        registrationPage
                .checkForm(studentName, studentNameValue)
                .checkForm(studentEmail, studentEmailValue)
                .checkForm(gender, genderValue)
                .checkForm(mobile, mobileValue)
                .checkForm(dateOfBirth, dateOfBirthValue)
                .checkForm(subjects, subjectsValue)
                .checkForm(hobbies, hobbiesValue)
                .checkForm(picture, pictureValue)
                .checkForm(stateAndCity, stateAndCityValue);
    }
}
