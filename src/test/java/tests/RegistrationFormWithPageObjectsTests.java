package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("remote")
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
                .checkForm(stateAndCity, stateAndCityValue);
    }
}
