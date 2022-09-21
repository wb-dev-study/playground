package hailey.racingcar.util;

import java.util.Arrays;

public class ValidationUtils {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static boolean validate(String carName, String[] carNames) {
        return validateCarNameLength(carName)
                && checkDuplicateName(carName, carNames);

    }

    private static boolean validateCarNameLength(String carName) {
        if (carName.length() <= CAR_NAME_LENGTH_LIMIT) return true;

        throw new IllegalArgumentException("자동차 이름은 5글자까지 가능합니다. ex) 가나다라마");
    }

    private static boolean checkDuplicateName(String name, String[] carNames) {
        if (Arrays.stream(carNames).anyMatch(carName -> carName.equals(name))) {
            throw new IllegalArgumentException(name + " 이 중복입니다.");
        };
        return true;
    }
}
