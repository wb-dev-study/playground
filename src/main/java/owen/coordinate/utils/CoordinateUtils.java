package owen.coordinate.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class CoordinateUtils {

    public static List<List<Integer>> convert(String string) {
        String replaceFirst = string.replace("(", "");
        String replaceSecond = replaceFirst.replace(")", "");
        List<List<Integer>> collect = Pattern.compile("-").splitAsStream(replaceSecond.trim()).map(i -> Arrays.stream(i.split(",")).map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
        return collect;
    }
}
