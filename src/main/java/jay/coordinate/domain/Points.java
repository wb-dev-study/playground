package jay.coordinate.domain;

import jay.coordinate.utils.CoordinateExtraction;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points;

    public Points() {
        this.points = new ArrayList<>();
    }

    public void add(List<String> strings) {
        for (String string : strings) {
            String[] coordinate = CoordinateExtraction.coordinatesSplitComma(string);
            this.points.add(new Point(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1])));
        }
    }

    public void add(Point point) {
        this.points.add(point);
    }

    public Integer getSize() {
        return points.size();
    }

    public Point get(int i) {
        return points.get(i);
    }
}
