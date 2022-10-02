package jay.coordinate.Factory;

import jay.coordinate.domain.Points;
import jay.coordinate.domain.figure.Quadrangle;
import jay.coordinate.service.Figure;
import jay.coordinate.service.FigureCreate;

public class QuadrangleFactory implements FigureCreate {
    @Override
    public Figure create(Points points) {
        return new Quadrangle(points);
    }
}
