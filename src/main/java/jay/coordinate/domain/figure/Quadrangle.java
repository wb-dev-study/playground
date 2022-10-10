package jay.coordinate.domain.figure;

import jay.coordinate.Factory.FigureFactory;
import jay.coordinate.domain.Lines;
import jay.coordinate.domain.Points;
import jay.coordinate.service.Figure;
import jay.coordinate.utils.CoordinateExtraction;
import jay.coordinate.views.Input;
import jay.coordinate.views.Output;

public class Quadrangle extends Figure {
    public Quadrangle(Points points) {
        this.points = points;
        this.lines = new Lines();
    }

    public static void main(String[] args) {

        Points points = new Points();
        points.add(CoordinateExtraction.coordinatesSplitHyphen(Input.inputCoordinate()));

        Figure quadrangle = FigureFactory.getInstance(points);
        quadrangle.createLines();
        quadrangle.setLinesToLinesLength();
        Output.quadrangleResultMessage(quadrangle.coordinateDistance());
    }

    @Override
    public Double coordinateDistance() {
        return lines.getLinesLength().get(0) * lines.getLinesLength().get(1);

    }

    @Override
    public void createLines() {
        lines.addLine(new Line(points.get(0), points.get(1)));
        lines.addLine(new Line(points.get(1), points.get(2)));
        lines.addLine(new Line(points.get(2), points.get(3)));
        lines.addLine(new Line(points.get(3), points.get(0)));
    }
}
