package hailey.baseball;

class ValidationUtils {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private ValidationUtils() {
        throw new IllegalArgumentException("숫자는 1~9 사이여야 합니다.");
    }

    public static int validateNumber(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return number;
        }
        throw new IllegalArgumentException("숫자는 1~9 사이여야 합니다.");
    }

    public static boolean checkNotDuplicate(int first, int second, int third) {
        return !(first==second || second==third || third==first);
    }
}
