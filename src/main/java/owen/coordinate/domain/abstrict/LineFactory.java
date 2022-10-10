package owen.coordinate.domain.abstrict;

import owen.coordinate.domain.Points;
import owen.coordinate.domain.figure.Line;

public class LineFactory implements FigureCreator {

    @Override
    public Figure create(Points points) {
        return new Line(points);
    }
}
