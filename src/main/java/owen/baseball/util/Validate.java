package owen.baseball.util;

import java.util.Arrays;

public class Validate {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private static final int BALL_SIZE = 3;

    public void validCheck(String[] userInput) {
        validationBasic(!isBallSize(userInput), "3자리의 숫자를 입력 바랍니다.");
        validationBasic(!isDuplicate(userInput), "중복된 숫자는 입력 불가능 합니다.");

        for (String inputString : userInput) {
            validationBasic(!isIntegerType(inputString), "정수만 입력 가능합니다.");
            validationBasic(!isRange(inputString), "1 ~ 9 까지의 정수만 입력이 가능합니다.");
        }
    }

    private boolean isDuplicate(String[] userInput) {
        return Arrays.stream(userInput).distinct().count() == userInput.length;
    }
    private boolean isBallSize(String[] userInput) {
        return userInput.length == BALL_SIZE;
    }

    private boolean isRange(String userInput) {
        return Integer.parseInt(userInput) >= MIN_NUMBER && Integer.parseInt(userInput) <= MAX_NUMBER;
    }

    private boolean isIntegerType(String inputString) {
        return inputString.matches("-?\\d+");
    }

    private void validationBasic(boolean expression, String exceptionMessage) {
        if (expression) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
