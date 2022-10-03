package owen.racingcar.utils;

public class RacingUtils {

    private RacingUtils() {

    }

    public static int parseInteger(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return result;
    }

    public static void printEndLine() {
        System.out.println("==============================");
    }

    public static void printConvert(String carName, StringBuilder beautyPosition) {
        System.out.println(carName + ":" + beautyPosition);
    }
}
