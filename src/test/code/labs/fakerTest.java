package labs;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class fakerTest {


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        String dob = sdf.format(faker.date().birthday());
        System.out.println("dob = " + dob);

        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.address().state() = " + faker.address().state());
        System.out.println("faker.number().randomNumber(6,true) = " + faker.number().randomNumber(6, true));
        System.out.println(faker.name().firstName().toLowerCase() + "@" + faker.name().firstName().toLowerCase() + ".com");


    }
}
