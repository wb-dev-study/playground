package jay.coordinate.Factory;

import jay.coordinate.domain.Points;
import jay.coordinate.domain.figure.Triangle;
import jay.coordinate.service.Figure;
import jay.coordinate.service.FigureCreate;

public class TriangleFactory implements FigureCreate {
    @Override
    public Figure create(Points points) {
        return new Triangle(points);
    }
}
