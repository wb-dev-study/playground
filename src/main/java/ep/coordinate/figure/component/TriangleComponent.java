package ep.coordinate.figure.component;

import ep.coordinate.figure.Triangle;
import ep.coordinate.Vertex;

import java.util.List;

public class TriangleComponent implements Component<Triangle> {

    public final static Integer TRIANGLE_VERTEX_SIZE = 3;
    private final Vertex vertex;


    public TriangleComponent(Vertex vertex) {
        validate(vertex);
        this.vertex = vertex;
    }

    private void validate(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("꼭지점은 null 이 아니어야 합니다.");
        }
        if (!vertex.getVertexSize().equals(TRIANGLE_VERTEX_SIZE)) {
            throw new IllegalArgumentException("삼각형의 꼭지점 개수는 " + TRIANGLE_VERTEX_SIZE + "이어야 합니다.");
        }
    }

    @Override
    public Triangle toFigure() {
        List<Double> eachLength = this.vertex.eachLength();
        if (eachLength.size() != 3) {
            throw new IllegalStateException("삼각형이 아닌 꼭지점입니다.");
        }
        return new Triangle(eachLength.get(0), eachLength.get(1), eachLength.get(2));
    }
}
