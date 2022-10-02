package owen.coordinate.domain.figure;

import owen.coordinate.domain.Coordinates;
import owen.coordinate.domain.Points;

import java.util.List;

public class Triangle extends AbstractFigure{

    private final static int TRIANGLE_CONDITION = 3;

    public Triangle(Points points) {
        super(points);
    }

    @Override
    public double calc() {
        double a = calculateLength(getCoordinates().get(0), getCoordinates().get(1));
        double b = calculateLength(getCoordinates().get(0), getCoordinates().get(2));
        double c = calculateLength(getCoordinates().get(1), getCoordinates().get(2));

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private double calculateLength(Coordinates first, Coordinates second) {
        double x = pow(first.getXPoint() - second.getXPoint());
        double y = pow(first.getYPoint() - second.getYPoint());

        return Math.sqrt(x + y);
    }

    private double pow(double num) {
        return num * num;
    }

    @Override
    public List<Coordinates> getCoordinates() {
        return super.getPoints().getCoordinates();
    }

    @Override
    public String getName() {
        return "삼각형";
    }

    @Override
    public int getSize() {
        return TRIANGLE_CONDITION;
    }

}
