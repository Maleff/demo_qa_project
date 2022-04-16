package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()"); // hide footer and banner
        executeJavaScript("$('#fixedban').remove()");
    }
    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }
    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }
    public void setUserEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);
    }
    public void  setUserNumber(String userNumber) {
        $("#userNumber").setValue(userNumber);
    }
    public void setUserBirthDay() {
        String month = "May",
                day = "30",
                year = "1995",
                fullBirthDay = month + " " + day + "th, " + year; //Пример составления строки

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month); //selectOption - для выбора из списка
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
    }
    public void setGender() {
        $("#gender-radio-3").parent().click();
    }
    public void setSubjects() {
        $("#subjectsContainer").click();
        String subject = "Bi";
        $("#subjectsInput").setValue(subject).pressEnter();
    }
    public void setHobbies() {
        $(byText("Music")).click();
        $(byText("Reading")).click();
    }
    public void uploadFile() {
        $("#uploadPicture").uploadFromClasspath("cat_file.jpg");
        //Отдельный файл в ресурсах - указать имя
    }
    public void setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
    }
    public void scroll() {
        $("#state").scrollIntoView(true).click(); //Скролл
    }
    public void setStateAndCity() {
        String state = "NCR";
        $(byText(state)).click();

        String city = "Gurgaon";
        $("#city").click();
        $(byText(city)).click();
    }
    public void submit() {
        $("#submit").click();
    }
    public void check() {
        $("#example-modal-sizes-title-lg").
                shouldHave(text("Thanks for submitting the form"));
    }
}

