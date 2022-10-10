package ep.coordinate.figure.factory;

import ep.coordinate.figure.Figure;
import ep.coordinate.figure.material.Vertex;

public interface FigureFactory<T extends Figure> {

    T vertexToFigure(Vertex vertex);
}
