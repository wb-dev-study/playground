package owen.coordinate.domain.figure;

import owen.coordinate.domain.Points;
import owen.coordinate.domain.abstrict.Figure;

abstract class AbstractFigure implements Figure {

    private final Points points;

     AbstractFigure(Points points) {
        if (points.getCoordinates().size() != getSize()) {
            throw new IllegalArgumentException(getName() + "은 " + getSize() + "개의 좌표가 필요합니다.");
        }
        this.points = points;
    }

    public Points getPoints() {
        return this.points;
    }
}
