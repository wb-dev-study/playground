package jay.coordinate.domain.figure;

import jay.coordinate.Factory.FigureFactory;
import jay.coordinate.domain.Lines;
import jay.coordinate.domain.Points;
import jay.coordinate.service.Figure;
import jay.coordinate.utils.CoordinateExtraction;
import jay.coordinate.views.Input;
import jay.coordinate.views.Output;

import java.io.IOException;

public class Triangle extends Figure {
    public Triangle(Points points) {
        this.points = points;
        this.lines = new Lines();
    }

    public static void main(String[] args) throws IOException {

        Points points = new Points();
        points.add(CoordinateExtraction.coordinatesSplitHyphen(Input.inputCoordinate()));

        Figure triangle = FigureFactory.getInstance(points);

        triangle.createLines();
        triangle.setLinesToLinesLength();
        Output.triangleResultMessage(triangle.coordinateDistance());
    }

    @Override
    public Double coordinateDistance() {
        double s = (lines.getLinesLength().get(0) + lines.getLinesLength().get(1) + lines.getLinesLength().get(2)) / 2;
        return Math.sqrt(s * ((s - lines.getLinesLength().get(0)) * (s - lines.getLinesLength().get(1)) * (s - lines.getLinesLength().get(2))));
    }


    @Override
    public void createLines() {
        lines.addLine(new Line(points.get(0), points.get(1)));
        lines.addLine(new Line(points.get(1), points.get(2)));
        lines.addLine(new Line(points.get(2), points.get(0)));
    }
}
