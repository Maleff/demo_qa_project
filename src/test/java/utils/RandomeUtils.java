package utils;

import java.util.Random;

public class RandomeUtils {
        public static String getRandomString(int length) {
            String SALTCHARS = "QWERTYUIOPASDFGHJKLZXCVBNM";
            StringBuilder result = new StringBuilder();
            Random rnd = new Random();
            while (result.length() < length) {
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                result.append(SALTCHARS.charAt(index));
            }
            return result.toString();
        }



        public static String getRandomEmail(){
            String emailDomen = "@test.qa";
            return  getRandomString(10) + emailDomen;
        }
}
