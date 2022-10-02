package ep.coordinate.figure.factory;

import ep.coordinate.figure.Vertex;

public interface FigureFactory<T> {

    T vertexToFigure(Vertex vertex);
}
