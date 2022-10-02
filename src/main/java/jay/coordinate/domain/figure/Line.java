package jay.coordinate.domain.figure;

import jay.coordinate.Factory.FigureFactory;
import jay.coordinate.domain.Point;
import jay.coordinate.domain.Points;
import jay.coordinate.service.Figure;
import jay.coordinate.utils.CoordinateExtraction;
import jay.coordinate.views.Input;
import jay.coordinate.views.Output;

public class Line extends Figure {
    public Line(Points points) {
        this.points = points;
    }

    public Line(Point pointA, Point pointB){
        this.points = new Points();
        points.add(pointA);
        points.add(pointB);
    }

    public static void main(String[] args) {
        Points points = new Points();
        points.add(CoordinateExtraction.coordinatesSplitHyphen(Input.inputCoordinate()));

        Figure line = FigureFactory.getInstance(points);
        Output.straightLineResultMessage(line.coordinateDistance());
    }

    @Override
    public Double coordinateDistance() {
        // 제곱근((A.x - B.x)^제곱 + (A.y - B.y)^제곱)
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        return Math.sqrt(Math.pow(pointA.getFirstCoordinate() - pointB.getFirstCoordinate(),2) + Math.pow(pointA.getSecondCoordinate() - pointB.getSecondCoordinate(),2));
    }

    @Override
    public void createLines() {
        lines.addLine(this);
    }
}
