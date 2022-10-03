package jay.racingcar.utils;

public class StringUtils {
    private static final String COMMA = ",";

    public static String[] splitInputName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        return name.split(COMMA);
    }
}
