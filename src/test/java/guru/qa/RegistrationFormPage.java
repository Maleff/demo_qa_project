package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


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






}

