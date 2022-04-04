package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*; //Для работы с разрешением экрана


public class TestPracticeForm {
    //data
    String name = "Maleff";
    String lastName = "Kuznja";
    String month = "May";
    String day = "8";
    String year = "1995";
    String gender = "Other";
    String fullBirthDay = month + " " + day + "th, " + year; //Пример составления строки
    String subject = "Bi";
    String currentAddress = "Italy, Provincia di Trapani, 23 st.";
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
        zoom(0.7); // Zoom out
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("maleff@gmail.com");
        $("#userNumber").setValue("89001239087");
        $(byText(gender)).click(); //Radio
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month); //selectOption - для выбора из списка
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label$='" + fullBirthDay + "']").click(); //Сложное - надо разобраться в синтаксисе
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

    }
}
