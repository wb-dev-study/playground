package hailey.racingcar.util;

public class ValidationUtils {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static boolean validate(int a, String carName, String[] carNames) {
        return validateCarNameLength(carName)
                && checkDuplicateName(a, carName, carNames);

    }

    private static boolean validateCarNameLength(String carName) {
        if (carName.length() <= CAR_NAME_LENGTH_LIMIT) return true;

        throw new IllegalArgumentException("자동차 이름은 5글자까지 가능합니다. ex) 가나다라마");
    }

    private static boolean checkDuplicateName(int a, String name, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (i != a && name.equals(carNames[i])) {
                throw new IllegalArgumentException(name + " 이 중복입니다.");
            }
        }
        return true;
    }
}
