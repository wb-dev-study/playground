package jay.coordinate.Factory;

import jay.coordinate.domain.Points;
import jay.coordinate.domain.figure.Line;
import jay.coordinate.service.Figure;
import jay.coordinate.service.FigureCreate;

public class LineFactory implements FigureCreate {
    @Override
    public Figure create(Points points) {
        return new Line(points);
    }
}
