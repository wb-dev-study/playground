package baseball;

class ValidationUtils {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int validateNumber(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return number;
        }
        throw new IllegalStateException("Utility class");
    }
}
