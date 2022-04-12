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
            email = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            fullName = format("%s %s", firstName, lastName),
            month = "May",
            day = "30";
    String year = "1995";
    String gender = "Other";
    String fullBirthDay = month + " " + day + "th, " + year; //Пример составления строки
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

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()"); // hide footer and banner
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue("89001239087");
        $("#gender-radio-3").parent().click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month); //selectOption - для выбора из списка
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
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