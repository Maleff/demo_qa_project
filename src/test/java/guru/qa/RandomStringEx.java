package guru.qa;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class RandomStringEx {
    public static void main (String[] args) {
        System.out.println("Randome string of 10 letters: " + getRandomString(10));
        System.out.println("Randome email: " + getRandomEmail());
    }
}
