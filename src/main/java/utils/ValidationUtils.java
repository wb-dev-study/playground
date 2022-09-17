package utils;

public class ValidationUtils {

    public static final int MIN = 1;
    public static final int MAX = 9;
    public static boolean validNumber(int number) {
        return number >= MIN && number <= MAX;
    }
}
