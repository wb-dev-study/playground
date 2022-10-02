package owen.coordinate;

import owen.coordinate.domain.abstrict.Figure;
import owen.coordinate.domain.abstrict.FigureCreator;
import owen.coordinate.domain.abstrict.LineFactory;
import owen.coordinate.domain.Points;
import owen.coordinate.domain.abstrict.RectangleFactory;
import owen.coordinate.domain.abstrict.TriangleFactory;

import java.util.HashMap;
import java.util.Map;

public class FigureFactory {

    private final Map<Integer, FigureCreator> figureMap = new HashMap<Integer, FigureCreator>() {{
        put(2, new LineFactory());
        put(3, new TriangleFactory());
        put(4, new RectangleFactory());
    }};

    public Figure createFigure(Points points) {
        Figure figure = figureMap.get(points.getCoordinates().size()).create(points);
        if (figure == null) {
            throw new IllegalArgumentException("피규어를 만들 수 없습니다.");
        }
        return figure;
    }
}
