package owen.coordinate.domain.figure;

import owen.coordinate.domain.Coordinates;
import owen.coordinate.domain.Points;

import java.util.List;

public class Line extends AbstractFigure {

    private final static int LINE_CONDITION = 2;

    public Line(Points points) {
        super(points);
    }

    @Override
    public double calc() {
        List<Coordinates> coordinates = getCoordinates();
        double x = pow(coordinates.get(0).getXPoint() - coordinates.get(1).getXPoint());
        double y = pow(coordinates.get(0).getYPoint() - coordinates.get(1).getYPoint());

        return Math.sqrt(x + y);
    }

    private double pow(double num) {
        return num * num;
    }

    @Override
    public String getName() {
        return "선";
    }

    @Override
    public int getSize() {
        return LINE_CONDITION;
    }

    @Override
    public List<Coordinates> getCoordinates() {
        return getPoints().getCoordinates();
    }
}
