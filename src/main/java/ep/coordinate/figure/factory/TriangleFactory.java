package ep.coordinate.figure.factory;

import ep.coordinate.figure.Triangle;
import ep.coordinate.figure.material.Vertex;
import ep.coordinate.figure.component.TriangleComponent;

public class TriangleFactory implements FigureFactory<Triangle> {

    @Override
    public Triangle vertexToFigure(Vertex vertex) {
        TriangleComponent triangleComponent = new TriangleComponent(vertex);
        return triangleComponent.toFigure();
    }
}
