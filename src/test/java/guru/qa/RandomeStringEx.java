package guru.qa;

import static utils.RandomeUtils.getRandomEmail;
import static utils.RandomeUtils.getRandomString;

public class RandomeStringEx {
    public static void main (String[] args) {
        System.out.println("Randome string of 10 letters: " + getRandomString(10));
        System.out.println("Randome email: " + getRandomEmail());
    }
}
