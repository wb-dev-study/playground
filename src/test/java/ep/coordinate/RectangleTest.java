package ep.coordinate;

import ep.coordinate.figure.Rectangle;
import ep.coordinate.figure.factory.FigureFactory;
import ep.coordinate.figure.factory.RectangleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {

    private FigureFactory<Rectangle> factory;

    @BeforeEach
    void setUp() {
        this.factory = new RectangleFactory();
    }

    @Test
    @DisplayName("사각형 넓이를 구할 수 있다")
    void rectangle_area() {
        Vertex vertex = new Vertex(new Position(10, 10), new Position(22, 10), new Position(22, 18), new Position(10, 18));
        Rectangle rectangle = factory.vertexToFigure(vertex);
        assertThat(rectangle.area()).isEqualTo(96.0);
    }
}
