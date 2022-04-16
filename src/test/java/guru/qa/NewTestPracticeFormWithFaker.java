package guru.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class NewTestPracticeFormWithFaker {
    Faker faker = new Faker();

    //data
    String  firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            fullName = format("%s %s", firstName, lastName),
            userNumber = "89001234590";

    String gender = "Other";
    String subject = "Bi";
    String state = "NCR";
    String city = "Gurgaon";


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

        $("#gender-radio-3").parent().click();
        registrationFormPage.setUserBirthDay();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Music")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("cat_file.jpg"); //Отдельный файл в ресурсах - указать имя
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollIntoView(true).click(); //Скролл
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}