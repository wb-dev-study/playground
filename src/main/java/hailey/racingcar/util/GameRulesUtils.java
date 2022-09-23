package hailey.racingcar.util;

public class GameRulesUtils {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int POSSIBLE_MIN_ADVANCE = 4;
    private static final int MIN_DICE_NUMBER = 0;
    private static final int MAX_DICE_NUMBER = 9;

    public static boolean validateCar(int order, String carName, String[] carNames) {
        return validateCarNameLength(carName)
                && checkDuplicateName(order, carName, carNames);

    }

    public static int validateAdvanceNumber(int number) {
        if (number >= MIN_DICE_NUMBER && number <= MAX_DICE_NUMBER) {
            return number;
        }
        throw new IllegalArgumentException("0~9 사이에 숫자만 가능");
    }

    public static boolean isPossibleAdvance(int advance) {
        return advance >= POSSIBLE_MIN_ADVANCE;
    }

    private static boolean validateCarNameLength(String carName) {
        if (carName.length() <= CAR_NAME_LENGTH_LIMIT) return true;

        throw new IllegalArgumentException("자동차 이름은 5글자까지 가능합니다. ex) 가나다라마");
    }

    private static boolean checkDuplicateName(int order, String name, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (i != order && name.equals(carNames[i])) {
                throw new IllegalArgumentException(name + " 이 중복입니다.");
            }
        }
        return true;
    }
}
