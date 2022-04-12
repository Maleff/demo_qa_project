package guru.qa;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerEx {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.aquaTeenHungerForce().character());
        System.out.println(faker.book().publisher());
        System.out.println(faker.animal().name());
        System.out.println(faker.internet().image());

        System.out.println(faker.address().fullAddress());

        Faker fakerDe = new Faker(new Locale("de"));
        System.out.println(fakerDe.address().fullAddress());


    }
}
