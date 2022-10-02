package ep.coordinate.figure.component;

import ep.coordinate.figure.Rectangle;
import ep.coordinate.figure.Vertex;

import java.util.List;
import java.util.Set;

public class RectangleComponent implements Component<Rectangle> {

    private final static Integer RECTANGLE_VERTEX_SIZE = 4;

    private final Vertex vertex;
    private List<Integer> xList;
    private List<Integer> yList;

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
        List<Integer> xList = vertex.toXList();
        List<Integer> yList = vertex.toYList();
        if (xList.size() != 2 || yList.size() != 2) {
            throw new IllegalArgumentException("직사각형이 되지 못하는 조건입니다.");
        }
        this.xList = xList;
        this.yList = yList;
    }

    @Override
    public Rectangle toFigure() {
        return new Rectangle(this.xList, this.yList);
    }
}
