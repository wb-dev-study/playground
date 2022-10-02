package jay.coordinate.utils;

import java.util.Arrays;
import java.util.List;

public class CoordinateExtraction {
    private static final String HYPHEN = "-";
    private static final String COMMA = ",";
    private static final String PATTERN = "[()]";

    public static List<String> coordinatesSplitHyphen(String coordinates){
        return Arrays.asList(coordinates.replaceAll(PATTERN, "").split(HYPHEN));
    }

    public static String[] coordinatesSplitComma(String coordinates){
        return coordinates.split(COMMA);
    }

}
