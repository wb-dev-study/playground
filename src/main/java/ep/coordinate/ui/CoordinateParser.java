package ep.coordinate.ui;

import ep.coordinate.figure.material.Position;

import java.util.ArrayList;
import java.util.List;

public class CoordinateParser {

    public static List<Position> parse(String coordinateList) {
        List<Position> list = new ArrayList<>();
        String[] split = coordinateList.split("\\)-\\(");
        for (String coordinate : split) {
            String clearedCoordinateStr = clearing(coordinate);
            Position position = parsePosition(clearedCoordinateStr);
            list.add(position);
        }
        return list;
    }

    private static String clearing(String coordinate) {
        String replace = coordinate.replace("(", "");
        String replace1 = replace.replace(")", "");
        return replace1.replace("-", "");
    }

    private static Position parsePosition(String coordinate) {
        try {
            String[] split = coordinate.split(",");
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);
            return new Position(first, second);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 문자열입니다.");
        }
    }

}
