package owen.coordinate.domain.abstrict;

import owen.coordinate.domain.Points;
import owen.coordinate.domain.figure.Rectangle;

public class RectangleFactory implements FigureCreator {

    @Override
    public Figure create(Points points) {
        return new Rectangle(points);
    }
}
