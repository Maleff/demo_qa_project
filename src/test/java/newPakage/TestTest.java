package newPakage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestTest {
    @Test
    void shouldOpen() {
        String date = "08.11.1995";
        LocalTime.parse(date);
        LocalDate.parse(date);

        Assertions.assertEquals(11, date);
    }
}
