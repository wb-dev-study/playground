package owen.coordinate.domain.figure;

import owen.coordinate.domain.Coordinates;
import owen.coordinate.domain.Points;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle extends AbstractFigure{


    private final static int RECTANGLE_CONDITION = 4;
    public Rectangle(Points points) {
        super(points);
    }

    @Override
    public double calc() {
        List<Coordinates> coordinates = getCoordinates();
        int xLength = calculateLength(getXValue(coordinates));
        int yLength = calculateLength(getYValue(coordinates));

        return xLength * yLength;
    }

    private int calculateLength(Set<Integer> point) {
        List<Integer> value = new ArrayList<>(point);
        return Math.abs(value.get(0) - value.get(1));
    }

    private Set<Integer> getXValue(List<Coordinates> coordinates) {
        Set<Integer> xValue = new HashSet<>();
        for (Coordinates coordinate : coordinates) {
            xValue.add(coordinate.getXPoint());
        }
        checkRectangle(xValue);
        return xValue;
    }

    private Set<Integer> getYValue(List<Coordinates> coordinates) {
        Set<Integer> yValue = new HashSet<>();
        for (Coordinates coordinate : coordinates) {
            yValue.add(coordinate.getYPoint());
        }
        checkRectangle(yValue);
        return yValue;
    }

    private void checkRectangle(Set<Integer> values) {
        if (values.size() != 2) {
            throw new IllegalArgumentException("사각형이 아닙니다.");
        }
    }

    @Override
    public List<Coordinates> getCoordinates() {
        return super.getPoints().getCoordinates();
    }

    @Override
    public String getName() {
        return "사각형";
    }

    @Override
    public int getSize() {
        return RECTANGLE_CONDITION;
    }
}
