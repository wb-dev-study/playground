package ep.coordinate;

import ep.coordinate.figure.Figure;
import ep.coordinate.figure.factory.FigureFactory;
import ep.coordinate.figure.factory.RectangleFactory;
import ep.coordinate.figure.factory.TriangleFactory;
import ep.coordinate.figure.material.Position;
import ep.coordinate.figure.material.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinateFactory {

    private final Vertex vertex;
    private static final Map<Integer, FigureFactory> figureFactoryMap = new HashMap<>();

    static {
        figureFactoryMap.put(3, new TriangleFactory());
        figureFactoryMap.put(4, new RectangleFactory());
    }

    public CoordinateFactory(List<Position> positions) {
        this.vertex = new Vertex(positions);
        if (figureFactoryMap.get(this.vertex.getVertexSize()) == null) {
            throw new IllegalArgumentException("해당하는 꼭지점 개수의 도형이 구현이되지 않았습니다.");
        }
    }

    public Figure figure() {
        return figureFactoryMap.get(vertex.getVertexSize()).vertexToFigure(this.vertex);
    }
}