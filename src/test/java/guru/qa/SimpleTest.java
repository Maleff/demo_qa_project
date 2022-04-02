package guru.qa;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @BeforeEach
    void openGoglPage() {
        Selenide.open("https://google.com");
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWindow();

    }
    @Test
    void assertTest () {
        Selenide.open();
        Assertions.assertTrue( 24 > 4);
    }
}
