package owen.coordinate.domain;

import owen.coordinate.domain.Point;

import java.util.List;

public class Coordinates {
    private final Point xPoint;
    private final Point yPoint;

    public Coordinates(List<Integer> list) {
        this.xPoint = new Point(list.get(0));
        this.yPoint = new Point(list.get(1));
    }

    public int getXPoint() {
        return xPoint.getPoint();
    }

    public int getYPoint() {
        return yPoint.getPoint();
    }
}
