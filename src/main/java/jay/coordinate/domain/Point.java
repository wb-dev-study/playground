package jay.coordinate.domain;

import jdk.nashorn.internal.objects.annotations.Getter;

public class Point {
    private final int firstCoordinate;
    private final int secondCoordinate;

    public Point(int firstCoordinate, int secondCoordinate) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    public double getFirstCoordinate() {
        return firstCoordinate;
    }

    public double getSecondCoordinate() {
        return secondCoordinate;
    }
}
