package ep.coordinate.figure.factory;

import ep.coordinate.figure.Rectangle;
import ep.coordinate.figure.material.Vertex;
import ep.coordinate.figure.component.RectangleComponent;

public class RectangleFactory implements FigureFactory<Rectangle> {

    @Override
    public Rectangle vertexToFigure(Vertex vertex) {
        RectangleComponent rectangleComponent = new RectangleComponent(vertex);
        return rectangleComponent.toFigure();
    }
}