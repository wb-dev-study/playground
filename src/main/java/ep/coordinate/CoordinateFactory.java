package ep.coordinate;

import ep.coordinate.figure.Figure;
import ep.coordinate.figure.Vertex;
import ep.coordinate.figure.factory.FigureFactory;
import ep.coordinate.figure.factory.RectangleFactory;
import ep.coordinate.figure.factory.TriangleFactory;

import java.util.List;

public class CoordinateFactory {

    private final Vertex vertex;
    private final FigureFactory figureFactory;

    public CoordinateFactory(List<Position> positions) {
        this.vertex = new Vertex(positions);
        switch (this.vertex.getVertexSize()) {
            case 3: {
                this.figureFactory = new TriangleFactory();
                break;
            }
            case 4: {
                this.figureFactory = new RectangleFactory();
                break;
            }
            default: {
                throw new IllegalArgumentException("해당하는 꼭지점의 도형이 구현이되지 않았습니다.");
            }
        }
    }

    public Figure figure() {
        return this.figureFactory.vertexToFigure(this.vertex);
    }
}
