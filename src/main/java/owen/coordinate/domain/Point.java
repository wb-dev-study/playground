package owen.coordinate.domain;

import java.util.Objects;

public class Point {
    private final int point;

    private final static int MAX_POINT = 24;

    public Point(int point) {
        if (point > MAX_POINT) {
            throw new IllegalArgumentException("24보다 큰 수는 입력할 수 없습니다");
        }
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
