package guru.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NewTestPracticeFormWithFaker {
    Faker faker = new Faker();
    //data
    String  firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            userNumber = "89001234590";

    @BeforeAll
    static void setUP() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1200x800";
    }

    @Test
    void fillFormatTest() {
        RegistrationFormPage registrationFormPage =
                new RegistrationFormPage();
        registrationFormPage.openPage();
        registrationFormPage.setFirstName(firstName);
        registrationFormPage.setLastName(lastName);
        registrationFormPage.setUserEmail(userEmail);
        registrationFormPage.setUserNumber(userNumber);
        registrationFormPage.setGender();
        registrationFormPage.setUserBirthDay();
        registrationFormPage.setSubjects();
        registrationFormPage.setHobbies();
        registrationFormPage.uploadFile();
        registrationFormPage.setCurrentAddress(currentAddress);
        registrationFormPage.scroll();
        registrationFormPage.setStateAndCity();
        registrationFormPage.submit();
        registrationFormPage.check();

    }
}