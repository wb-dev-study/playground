package ep.coordinate.figure.component;

import ep.coordinate.figure.Rectangle;
import ep.coordinate.Vertex;

import java.util.List;

public class RectangleComponent implements Component<Rectangle> {

    private final static Integer RECTANGLE_VERTEX_SIZE = 4;

    private final Vertex vertex;

    public RectangleComponent(final Vertex vertex) {
        validate(vertex);
        this.vertex = vertex;
    }

    private void validate(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("꼭지점은 null 이 아니어야 합니다.");
        }
        if (!vertex.getVertexSize().equals(RECTANGLE_VERTEX_SIZE)) {
            throw new IllegalArgumentException("사각형의 꼭지점 개수는 " + RECTANGLE_VERTEX_SIZE + "이어야 합니다.");
        }
        if (vertex.toXDistinctList().size() != 2 || vertex.toYDistinctList().size() != 2) {
            throw new IllegalArgumentException("직사각형이 되지 못하는 조건입니다.");
        }
    }

    @Override
    public Rectangle toFigure() {
        List<Integer> xList = vertex.toXDistinctList();
        List<Integer> yList = vertex.toYDistinctList();
        Integer width = Math.abs(xList.get(0) - xList.get(1));
        Integer height = Math.abs(yList.get(0) - yList.get(1));
        return new Rectangle(width, height);
    }
}
