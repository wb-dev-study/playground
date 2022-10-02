package owen.coordinate.domain.abstrict;

import owen.coordinate.domain.Points;
import owen.coordinate.domain.figure.Triangle;

public class TriangleFactory implements FigureCreator {

    @Override
    public Figure create(Points points) {
        return new Triangle(points);
    }
}
