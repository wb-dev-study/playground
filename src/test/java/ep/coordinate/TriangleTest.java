package ep.coordinate;

import ep.coordinate.figure.Triangle;
import ep.coordinate.figure.Vertex;
import ep.coordinate.figure.factory.FigureFactory;
import ep.coordinate.figure.factory.TriangleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {

    private FigureFactory<Triangle> factory;

    @BeforeEach
    void setUp() {
        this.factory = new TriangleFactory();
    }

    @Test
    @DisplayName("삼각형 넓이를 구할 수 있다")
    void triangle_area() {
        Vertex vertex = new Vertex(new Position(10, 10), new Position(14, 15), new Position(20, 8));
        Triangle triangle = factory.vertexToFigure(vertex);
        assertThat(triangle.area()).isEqualTo(29.0, offset(0.1));
    }
}