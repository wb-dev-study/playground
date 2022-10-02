package jay.coordinate.Factory;

import jay.coordinate.domain.Points;
import jay.coordinate.service.Figure;
import jay.coordinate.service.FigureCreate;

import java.util.HashMap;
import java.util.Map;

public class FigureFactory {
    private static final Map<Integer, FigureCreate> creators = new HashMap<>();

    static {
        creators.put(2, new LineFactory());
        creators.put(3, new TriangleFactory());
        creators.put(4, new QuadrangleFactory());
    }

    public static Figure getInstance(Points points) {
        FigureCreate figureCreator = creators.get(points.getSize());
        if (figureCreator == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return figureCreator.create(points);
    }
}
